package main;

import entity.Entity;

import object.OBJ_Heart;
import object.OBJ_goldCoin;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;

    Graphics2D g2;
    Font arial_40,arial_80B;
    public boolean messageOn=false;
    public String message="";
    public int commandNum=0;
    int messageCounter=0;
    BufferedImage heart_full,heart_half,heart_blank,coins_image;
    public boolean gameFinished=false;
    double playTime;
    DecimalFormat dFormat=new DecimalFormat("#0.00");
    public UI(GamePanel gp){
        this.gp=gp;
        arial_40=new Font("Arial",Font.PLAIN,40);
        arial_80B=new Font("Arial",Font.BOLD,80);

        //CREATE HUD OBJECT
        Entity heart =new OBJ_Heart(gp);
        heart_full=heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;
        Entity coins=new OBJ_goldCoin(gp);
        coins_image=coins.down1;
    }
    public void showMessage(String text){
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2){
        this.g2=g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if(gp.gameState==gp.TitleState){
            drawTitleScreen();
        }

        if(gp.gameState==gp.playState){
            drawPlayerLife();
            drawCoinCounter();
            drawPlayerXY();
            drawScore();
        }
        if(gp.gameState==gp.pauseState){
            drawPauseScreen();

        }
        if(gp.gameState==gp.gameOverState){
            drawGameOverScreen();
        }



    }
    public void drawTitleScreen(){
        //background color
        g2.setColor(new Color(60,30,90));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
        String text="GALAXY ADVENTURES";
        int x=getXforCenter(text);
        int y=gp.tileSize*3;

        //shadows
        g2.setColor(Color.BLACK);
        g2.drawString(text,x+5,y+5);

        //text color
        g2.setColor(Color.white);
        g2.drawString(text,x,y);

        //icon
        x=gp.screenWidth/2-(gp.tileSize);
        y+=gp.tileSize*2;
        g2.drawImage(gp.player.boss,x,y,gp.tileSize*2,gp.tileSize*2,null);
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text="NEW GAME";
        x=getXforCenter(text);
        y+=gp.tileSize*3.5;
        g2.drawString(text,x,y);
        if(commandNum==0){
            g2.drawString(">",x-gp.tileSize/2,y);
        }

        text="LOAD GAME";
        x=getXforCenter(text);
        y+=gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum==1){
            g2.drawString(">",x-gp.tileSize/2,y);
        }

        text="QUIT";
        x=getXforCenter(text);
        y+=gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum==2){
            g2.drawString(">",x-gp.tileSize/2,y);
        }


    }
    public void drawPlayerLife(){
        //gp.player.life=1;
        int x=gp.tileSize/8;
        int y=gp.tileSize/8;
        int i=0;

        //DRAW BLANK HEART
        while(i<gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,null);
            i++;
            x+=gp.tileSize;
        }
        //RESET
        x=gp.tileSize/8;
        y=gp.tileSize/8;
        i=0;

        //DRAW CURRENT LIFE
        while(i<gp.player.life){
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x+=gp.tileSize;
        }
    }
    public void drawCoinCounter(){
        int x=gp.tileSize/8;
        int y=gp.tileSize;
        g2.drawImage(coins_image,x,y,null);
        x=gp.tileSize;
        y=gp.tileSize*2-gp.tileSize/2;
        g2.setFont(g2.getFont().deriveFont(30F));
        g2.drawString("x",x,y);
        x+=gp.tileSize/2;
        g2.drawString(String.valueOf(gp.player.coin),x,y);
    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text="PAUSED";
        int x,y;
        x=getXforCenter(text);
        y=gp.screenHeight/2;

        g2.drawString(text,x,y);
    }
    public void drawGameOverScreen(){
        g2.setColor(new Color(0, 0, 10, 150));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        int x,y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));

        text="GAME OVER";

        g2.setColor(Color.black);
        x=getXforCenter(text);
        y=gp.tileSize*4;
        g2.drawString(text,x,y);

        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);

    }
    public int getXforCenter(String text){

        int lenght=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x=gp.screenWidth/2-lenght/2;
        return x;
    }
    public void drawPlayerXY(){
        int x=gp.tileSize/4;
        int y=gp.tileSize*12;
        g2.drawString(String.valueOf(gp.player.worldX/gp.tileSize),x,y);
        x=gp.tileSize*3;
        g2.drawString(String.valueOf(gp.player.worldY/gp.tileSize),x,y);
    }
    public void drawScore(){
        int x=gp.tileSize/4;
        int y=gp.tileSize*2+gp.tileSize/4;
        g2.drawString("SCORE: ",x,y);
        x=gp.tileSize*2;
        g2.drawString(String.valueOf(gp.player.score),x,y);
    }
}
