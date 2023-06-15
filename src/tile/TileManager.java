package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[]tile;
    public int mapTileNum[][][];

    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
        mapTileNum=new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/world02.txt",0);
        loadMap("/maps/world03.txt",1);
        loadMap("/maps/world04.txt",2);
    }
    public void getTileImage() {

        tile[0] = new Tile();
        tile[1] = new Tile();
        tile[2] = new Tile();
        tile[3] = new Tile();
        tile[4] = new Tile();
        tile[5] = new Tile();
        tile[6] = new Tile();
        tile[0].image = null;
        tile[1].image = setup("/tiles/Meteor1", gp.tileSize, gp.tileSize);
        tile[2].image = setup("/tiles/Meteor2", gp.tileSize, gp.tileSize);
        tile[3].image = setup("/tiles/Bomb_01_1", gp.tileSize, gp.tileSize);
        tile[4].image = setup("/tiles/meteor3",gp.tileSize,gp.tileSize);
        tile[5].image = setup("/tiles/Crystal2",gp.tileSize,gp.tileSize);
        tile[6].image = setup("/tiles/cristal", gp.tileSize, gp.tileSize);
        tile[3].collision = true;
        tile[1].collision = true;
        tile[2].collision = true;
        tile[4].collision = true;
        tile[5].collision = true;
        tile[6].collision = true;

    }

    public void loadMap(String filePath,int map){

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line= br.readLine();//read a line of text and put it in ,,line" var

                while(col<gp.maxWorldCol){
                    String numbers[]=line.split(" ");//splits the string around " "

                    int num=Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row]=num;
                    col++;
                }
                col=0;
                row++;


            }
            br.close();


        }catch (Exception e){

        }
    }
    public void draw(Graphics2D g2)
    {
        int worldCol=0;
        int worldRow=0;


        while(worldCol<gp.maxWorldCol&&worldRow<gp.maxWorldRow){

            int tileNum=mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX=worldCol*gp.tileSize;
            int worldY=worldRow*gp.tileSize;

            int screenX=worldX-gp.player.worldX+gp.player.screenX;
            int screenY=worldY-gp.player.worldY+gp.player.screenY;

            if(worldX>gp.player.worldX-gp.player.screenX&&
               worldX<gp.player.worldX+gp.player.screenX&&
               worldY>gp.player.worldY-gp.player.screenY&&
               worldY<gp.player.worldY+gp.player.screenY)//to only load the tiles that we see on the screen
            {
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
            }

            worldCol++;

            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;

            }
        }
    }
    public BufferedImage setup(String imagePath, int width, int height){
        UtilityTool uTool=new UtilityTool();
        BufferedImage image=null;

        try{
            image= ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
            image=uTool.scaleImage(image,width,height);

        }catch(IOException e){
            e.printStackTrace();
        }
        return image;

    }
}

