package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][][];
    Graphics2D g2;
    public EventHandler(GamePanel gp){
        this.gp=gp;

        eventRect=new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map=0;
        int col=0;
        int row=0;
        while(map<gp.maxMap&&col<gp.maxWorldCol && row<gp.maxWorldRow){
            eventRect[map][col][row]=new EventRect();
            eventRect[map][col][row].x=23;
            eventRect[map][col][row].y=23;
            eventRect[map][col][row].width=2;
            eventRect[map][col][row].height=2;
            eventRect[map][col][row].eventRectDefaultX=eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY=eventRect[map][col][row].y;

            col++;
            if(col==gp.maxWorldCol){
                col=0;
                row++;

                if(row==gp.maxWorldRow){
                    row=0;
                    map++;
                }
            }
        }

    }
    public void checkEvent(){

        if(hit(0,8,3,"any")){teleport(1,8,60);gp.player.saveScoresToDatabase();}
        if(hit(1,8,3,"any")){teleport(2,8,60);gp.player.saveScoresToDatabase();}
        if(hit(2,8,3,"any")){gp.player.saveScoresToDatabase();}
    }
    public boolean hit(int map,int col,int row,String reqDirection){

            boolean hit=false;
            if(map==gp.currentMap){
                gp.player.solidArea.x=gp.player.worldX+gp.player.solidArea.x;
                gp.player.solidArea.y=gp.player.worldY+gp.player.solidArea.y;
                eventRect[map][col][row].x=col*gp.tileSize+eventRect[map][col][row].x;
                eventRect[map][col][row].y=row*gp.tileSize+eventRect[map][col][row].y;

                if(gp.player.solidArea.intersects(eventRect[map][col][row])&&eventRect[map][col][row].eventDone==false){
                    if(gp.player.direction.contentEquals(reqDirection)||reqDirection.contentEquals("any")){
                        hit=true;
                    }
                }

                gp.player.solidArea.x=gp.player.solidAreaDefaultX;
                gp.player.solidArea.y=gp.player.solidAreaDefaultY;
                eventRect[map][col][row].x=eventRect[map][col][row].eventRectDefaultX;
                eventRect[map][col][row].y=eventRect[map][col][row].eventRectDefaultY;

            }
            return hit;
    }

    public void teleport(int map,int col,int row){
        gp.currentMap=map;
        gp.player.worldX=gp.tileSize*col;
        gp.player.worldY=gp.tileSize*row;
    }


}
