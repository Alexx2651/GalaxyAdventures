package main;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

import entity.Entity;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize=16;//16x16 tile
    final int scale=4;
    public final int tileSize=originalTileSize*scale;//64x64 tile
    public final int maxScreenCol=16;
    public final int maxScreenRow=12;
    public final int screenWidth=tileSize*maxScreenCol;//1024 pixels
    public final int screenHeight=tileSize*maxScreenRow;//768 pixels

    //WORLD SETTING
    public final int maxWorldCol=15;
    public final int maxWorldRow=65;
    public final int maxMap=10;
    public int currentMap=0;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxScreenRow;
    //FPS
    int FPS=60;
    //SYSTEM
    TileManager tileM=new TileManager(this);
    public KeyHandler keyH=new KeyHandler(this);
    public EventHandler eHandler=new EventHandler(this);
    Thread gameThread;
    //ENTITY AND OBJECT
    public CollisionChecker cChecker=new CollisionChecker(this);
    public BonusSetter bSetter=new BonusSetter(this);
    public UI ui=new UI(this);
    public Player player=new Player(this,keyH);
    public Entity obj[][]=new Entity[maxMap][100];
    public Entity monster[][]=new Entity[maxMap][150];
    public ArrayList<Entity>projectileList=new ArrayList<>();
    //public ArrayList<Entity>EntityList=new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int TitleState=0;
    public final int playState=1;
    public final int pauseState=2;
    public final int gameOverState=6;
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        bSetter.setObject();
        bSetter.setMonster();
        gameState=TitleState;
    }
    public void startGameThread()
    {
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval= 1_000_000_000 /FPS;
        double nextDrawTime=System.nanoTime()+drawInterval;


        while(gameThread!=null)
        {
            update();
            repaint();
            try {
                double remainingTime=nextDrawTime-System.nanoTime();
                remainingTime=remainingTime/1000000;
                if(remainingTime<0){
                    remainingTime=0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void update(){
        if(gameState==playState){
            player.update();
            for(int i=0;i<monster[1].length;i++){
                if(monster[currentMap][i]!=null){
                    monster[currentMap][i].update();
                    if(monster[currentMap][i].alive==false){
                        monster[currentMap][i].checkDrop();
                        monster[currentMap][i]=null;
                    }
                }
            }
            for(int i=0;i<projectileList.size();i++){
                if(projectileList.get(i)!=null){
                    if(projectileList.get(i).alive==true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive==false){
                        projectileList.remove(i);
                    }
                }
            }
        }
        //enemy
        if(gameState==pauseState){
            //nothing yet
        }


    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;

        //TITLE SCREEN
        if(gameState==TitleState){
            ui.draw(g2);
        }
        else{
            //background
            if(currentMap==0){
                g.drawImage(player.bg, 0, 0, null);
            }
            else if(currentMap==1){
                g.drawImage(player.bg1, 0, 0, null);
            }
            else if(currentMap==2){
                g.drawImage(player.bg2,0,0,null);
            }
            //TILE
            tileM.draw(g2);
            //OBJECT
            for(int i=0;i<obj[1].length;i++){//we need to know what kind of obj to show
                if(obj[currentMap][i]!=null){//to avoid NULLPTR error
                    obj[currentMap][i].draw(g2);
                }
            }
            //enemy
            for(int i=0;i<monster[1].length;i++){
                if(monster[currentMap][i]!=null){
                    monster[currentMap][i].draw(g2);
                }
            }
            for(int i=0;i<projectileList.size();i++){
                if(projectileList.get(i)!=null){
                    projectileList.get(i).draw(g2);
                }
            }

            //PLAYER
            player.draw(g2);
            //UI
            ui.draw(g2);
        }
        g2.dispose();
    }
}
