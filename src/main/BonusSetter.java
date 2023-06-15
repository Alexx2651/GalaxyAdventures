package main;

import monster.MON_Betas;
import monster.MON_Cristalions;
import monster.MON_Vipers;
import object.*;

public class BonusSetter {
    GamePanel gp;
    public BonusSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        int mapNum=0;
        int i=0;
        gp.obj[mapNum][i]=new OBJ_goldCoin(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*10;
        gp.obj[mapNum][i].worldY=gp.tileSize*60;
        i++;
        gp.obj[mapNum][i]=new OBJ_Coin(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*3;
        i++;
        gp.obj[mapNum][i]=new OBJ_Speed(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*7;
        gp.obj[mapNum][i].worldY=gp.tileSize*49;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*5;
        gp.obj[mapNum][i].worldY=gp.tileSize*50;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*5;
        gp.obj[mapNum][i].worldY=gp.tileSize*60;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*10;
        gp.obj[mapNum][i].worldY=gp.tileSize*43;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*7;
        gp.obj[mapNum][i].worldY=gp.tileSize*32;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*3;
        gp.obj[mapNum][i].worldY=gp.tileSize*16;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*9;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*27;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*4;
        gp.obj[mapNum][i].worldY=gp.tileSize*13;
        i++;
        mapNum=1;
        gp.obj[mapNum][i]=new OBJ_Coin(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*3;
        i++;
        gp.obj[mapNum][i]=new OBJ_Speed(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*9;
        gp.obj[mapNum][i].worldY=gp.tileSize*47;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*50;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*5;
        gp.obj[mapNum][i].worldY=gp.tileSize*60;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*10;
        gp.obj[mapNum][i].worldY=gp.tileSize*43;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*7;
        gp.obj[mapNum][i].worldY=gp.tileSize*32;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*3;
        gp.obj[mapNum][i].worldY=gp.tileSize*16;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*9;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*27;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*4;
        gp.obj[mapNum][i].worldY=gp.tileSize*13;
        i++;
        gp.obj[mapNum][i]=new OBJ_Dmg(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*4;
        gp.obj[mapNum][i].worldY=gp.tileSize*45;
        mapNum=2;
        gp.obj[mapNum][i]=new OBJ_goldCoin(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*10;
        gp.obj[mapNum][i].worldY=gp.tileSize*60;
        i++;
        gp.obj[mapNum][i]=new OBJ_Coin(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*3;
        i++;
        gp.obj[mapNum][i]=new OBJ_Speed(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*7;
        gp.obj[mapNum][i].worldY=gp.tileSize*49;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*5;
        gp.obj[mapNum][i].worldY=gp.tileSize*50;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*5;
        gp.obj[mapNum][i].worldY=gp.tileSize*60;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*10;
        gp.obj[mapNum][i].worldY=gp.tileSize*43;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*7;
        gp.obj[mapNum][i].worldY=gp.tileSize*32;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*3;
        gp.obj[mapNum][i].worldY=gp.tileSize*16;
        i++;
        gp.obj[mapNum][i]=new OBJ_Bomb(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*9;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*8;
        gp.obj[mapNum][i].worldY=gp.tileSize*27;
        i++;
        gp.obj[mapNum][i]=new OBJ_BonusHp(gp);
        gp.obj[mapNum][i].worldX=gp.tileSize*4;
        gp.obj[mapNum][i].worldY=gp.tileSize*13;

    }

    public void setMonster(){
        int mapNum=0;
        gp.monster[mapNum][0]=new MON_Betas(gp);
        gp.monster[mapNum][0].worldX=6*gp.tileSize;
        gp.monster[mapNum][0].worldY=55*gp.tileSize;

        gp.monster[mapNum][1]=new MON_Betas(gp);
        gp.monster[mapNum][1].worldX=13*gp.tileSize;
        gp.monster[mapNum][1].worldY=55*gp.tileSize;

        gp.monster[mapNum][2]=new MON_Betas(gp);
        gp.monster[mapNum][2].worldX=8*gp.tileSize;
        gp.monster[mapNum][2].worldY=55*gp.tileSize;

        gp.monster[mapNum][3]=new MON_Betas(gp);
        gp.monster[mapNum][3].worldX=2*gp.tileSize;
        gp.monster[mapNum][3].worldY=54*gp.tileSize;

        gp.monster[mapNum][4]=new MON_Betas(gp);
        gp.monster[mapNum][4].worldX=10*gp.tileSize;
        gp.monster[mapNum][4].worldY=54*gp.tileSize;

        gp.monster[mapNum][5]=new MON_Betas(gp);
        gp.monster[mapNum][5].worldX=6*gp.tileSize;
        gp.monster[mapNum][5].worldY=35*gp.tileSize;

        gp.monster[mapNum][6]=new MON_Betas(gp);
        gp.monster[mapNum][6].worldX=13*gp.tileSize;
        gp.monster[mapNum][6].worldY=35*gp.tileSize;

        gp.monster[mapNum][7]=new MON_Betas(gp);
        gp.monster[mapNum][7].worldX=8*gp.tileSize;
        gp.monster[mapNum][7].worldY=35*gp.tileSize;

        gp.monster[mapNum][8]=new MON_Betas(gp);
        gp.monster[mapNum][8].worldX=2*gp.tileSize;
        gp.monster[mapNum][8].worldY=34*gp.tileSize;

        gp.monster[mapNum][9]=new MON_Betas(gp);
        gp.monster[mapNum][9].worldX=10*gp.tileSize;
        gp.monster[mapNum][9].worldY=34*gp.tileSize;

        gp.monster[mapNum][10]=new MON_Betas(gp);
        gp.monster[mapNum][10].worldX=6*gp.tileSize;
        gp.monster[mapNum][10].worldY=21*gp.tileSize;

        gp.monster[mapNum][11]=new MON_Betas(gp);
        gp.monster[mapNum][11].worldX=13*gp.tileSize;
        gp.monster[mapNum][11].worldY=21*gp.tileSize;

        gp.monster[mapNum][12]=new MON_Betas(gp);
        gp.monster[mapNum][12].worldX=8*gp.tileSize;
        gp.monster[mapNum][12].worldY=21*gp.tileSize;

        gp.monster[mapNum][13]=new MON_Betas(gp);
        gp.monster[mapNum][13].worldX=2*gp.tileSize;
        gp.monster[mapNum][13].worldY=20*gp.tileSize;

        gp.monster[mapNum][14]=new MON_Betas(gp);
        gp.monster[mapNum][14].worldX=10*gp.tileSize;
        gp.monster[mapNum][14].worldY=20*gp.tileSize;

        gp.monster[mapNum][15]=new MON_Betas(gp);
        gp.monster[mapNum][15].worldX=6*gp.tileSize;
        gp.monster[mapNum][15].worldY=6*gp.tileSize;

        gp.monster[mapNum][16]=new MON_Betas(gp);
        gp.monster[mapNum][16].worldX=13*gp.tileSize;
        gp.monster[mapNum][16].worldY=5*gp.tileSize;

        gp.monster[mapNum][17]=new MON_Betas(gp);
        gp.monster[mapNum][17].worldX=8*gp.tileSize;
        gp.monster[mapNum][17].worldY=6*gp.tileSize;

        gp.monster[mapNum][18]=new MON_Betas(gp);
        gp.monster[mapNum][18].worldX=2*gp.tileSize;
        gp.monster[mapNum][18].worldY=5*gp.tileSize;

        gp.monster[mapNum][19]=new MON_Betas(gp);
        gp.monster[mapNum][19].worldX=10*gp.tileSize;
        gp.monster[mapNum][19].worldY=5*gp.tileSize;

        mapNum=1;
        gp.monster[mapNum][0]=new MON_Cristalions(gp);
        gp.monster[mapNum][0].worldX=6*gp.tileSize;
        gp.monster[mapNum][0].worldY=55*gp.tileSize;

        gp.monster[mapNum][1]=new MON_Cristalions(gp);
        gp.monster[mapNum][1].worldX=13*gp.tileSize;
        gp.monster[mapNum][1].worldY=55*gp.tileSize;

        gp.monster[mapNum][2]=new MON_Cristalions(gp);
        gp.monster[mapNum][2].worldX=8*gp.tileSize;
        gp.monster[mapNum][2].worldY=55*gp.tileSize;

        gp.monster[mapNum][3]=new MON_Cristalions(gp);
        gp.monster[mapNum][3].worldX=2*gp.tileSize;
        gp.monster[mapNum][3].worldY=54*gp.tileSize;

        gp.monster[mapNum][4]=new MON_Cristalions(gp);
        gp.monster[mapNum][4].worldX=10*gp.tileSize;
        gp.monster[mapNum][4].worldY=54*gp.tileSize;

        gp.monster[mapNum][5]=new MON_Cristalions(gp);
        gp.monster[mapNum][5].worldX=6*gp.tileSize;
        gp.monster[mapNum][5].worldY=35*gp.tileSize;

        gp.monster[mapNum][6]=new MON_Cristalions(gp);
        gp.monster[mapNum][6].worldX=13*gp.tileSize;
        gp.monster[mapNum][6].worldY=35*gp.tileSize;

        gp.monster[mapNum][7]=new MON_Cristalions(gp);
        gp.monster[mapNum][7].worldX=8*gp.tileSize;
        gp.monster[mapNum][7].worldY=35*gp.tileSize;

        gp.monster[mapNum][8]=new MON_Cristalions(gp);
        gp.monster[mapNum][8].worldX=2*gp.tileSize;
        gp.monster[mapNum][8].worldY=34*gp.tileSize;

        gp.monster[mapNum][9]=new MON_Cristalions(gp);
        gp.monster[mapNum][9].worldX=10*gp.tileSize;
        gp.monster[mapNum][9].worldY=34*gp.tileSize;

        gp.monster[mapNum][10]=new MON_Cristalions(gp);
        gp.monster[mapNum][10].worldX=6*gp.tileSize;
        gp.monster[mapNum][10].worldY=21*gp.tileSize;

        gp.monster[mapNum][11]=new MON_Cristalions(gp);
        gp.monster[mapNum][11].worldX=13*gp.tileSize;
        gp.monster[mapNum][11].worldY=21*gp.tileSize;

        gp.monster[mapNum][12]=new MON_Cristalions(gp);
        gp.monster[mapNum][12].worldX=8*gp.tileSize;
        gp.monster[mapNum][12].worldY=21*gp.tileSize;

        gp.monster[mapNum][13]=new MON_Cristalions(gp);
        gp.monster[mapNum][13].worldX=2*gp.tileSize;
        gp.monster[mapNum][13].worldY=20*gp.tileSize;

        gp.monster[mapNum][14]=new MON_Cristalions(gp);
        gp.monster[mapNum][14].worldX=10*gp.tileSize;
        gp.monster[mapNum][14].worldY=20*gp.tileSize;

        gp.monster[mapNum][15]=new MON_Cristalions(gp);
        gp.monster[mapNum][15].worldX=6*gp.tileSize;
        gp.monster[mapNum][15].worldY=6*gp.tileSize;

        gp.monster[mapNum][16]=new MON_Cristalions(gp);
        gp.monster[mapNum][16].worldX=13*gp.tileSize;
        gp.monster[mapNum][16].worldY=5*gp.tileSize;

        gp.monster[mapNum][17]=new MON_Cristalions(gp);
        gp.monster[mapNum][17].worldX=8*gp.tileSize;
        gp.monster[mapNum][17].worldY=6*gp.tileSize;

        gp.monster[mapNum][18]=new MON_Cristalions(gp);
        gp.monster[mapNum][18].worldX=2*gp.tileSize;
        gp.monster[mapNum][18].worldY=5*gp.tileSize;

        gp.monster[mapNum][19]=new MON_Cristalions(gp);
        gp.monster[mapNum][19].worldX=10*gp.tileSize;
        gp.monster[mapNum][19].worldY=5*gp.tileSize;

        mapNum=2;
        gp.monster[mapNum][0]=new MON_Vipers(gp);
        gp.monster[mapNum][0].worldX=6*gp.tileSize;
        gp.monster[mapNum][0].worldY=55*gp.tileSize;

        gp.monster[mapNum][1]=new MON_Vipers(gp);
        gp.monster[mapNum][1].worldX=13*gp.tileSize;
        gp.monster[mapNum][1].worldY=55*gp.tileSize;

        gp.monster[mapNum][2]=new MON_Vipers(gp);
        gp.monster[mapNum][2].worldX=8*gp.tileSize;
        gp.monster[mapNum][2].worldY=55*gp.tileSize;

        gp.monster[mapNum][3]=new MON_Vipers(gp);
        gp.monster[mapNum][3].worldX=2*gp.tileSize;
        gp.monster[mapNum][3].worldY=54*gp.tileSize;

        gp.monster[mapNum][4]=new MON_Vipers(gp);
        gp.monster[mapNum][4].worldX=10*gp.tileSize;
        gp.monster[mapNum][4].worldY=54*gp.tileSize;

        gp.monster[mapNum][5]=new MON_Vipers(gp);
        gp.monster[mapNum][5].worldX=6*gp.tileSize;
        gp.monster[mapNum][5].worldY=35*gp.tileSize;

        gp.monster[mapNum][6]=new MON_Vipers(gp);
        gp.monster[mapNum][6].worldX=13*gp.tileSize;
        gp.monster[mapNum][6].worldY=35*gp.tileSize;

        gp.monster[mapNum][7]=new MON_Vipers(gp);
        gp.monster[mapNum][7].worldX=8*gp.tileSize;
        gp.monster[mapNum][7].worldY=35*gp.tileSize;

        gp.monster[mapNum][8]=new MON_Vipers(gp);
        gp.monster[mapNum][8].worldX=2*gp.tileSize;
        gp.monster[mapNum][8].worldY=34*gp.tileSize;

        gp.monster[mapNum][9]=new MON_Vipers(gp);
        gp.monster[mapNum][9].worldX=10*gp.tileSize;
        gp.monster[mapNum][9].worldY=34*gp.tileSize;

        gp.monster[mapNum][10]=new MON_Vipers(gp);
        gp.monster[mapNum][10].worldX=6*gp.tileSize;
        gp.monster[mapNum][10].worldY=21*gp.tileSize;

        gp.monster[mapNum][11]=new MON_Vipers(gp);
        gp.monster[mapNum][11].worldX=13*gp.tileSize;
        gp.monster[mapNum][11].worldY=21*gp.tileSize;

        gp.monster[mapNum][12]=new MON_Vipers(gp);
        gp.monster[mapNum][12].worldX=8*gp.tileSize;
        gp.monster[mapNum][12].worldY=21*gp.tileSize;

        gp.monster[mapNum][13]=new MON_Vipers(gp);
        gp.monster[mapNum][13].worldX=2*gp.tileSize;
        gp.monster[mapNum][13].worldY=20*gp.tileSize;

        gp.monster[mapNum][14]=new MON_Vipers(gp);
        gp.monster[mapNum][14].worldX=10*gp.tileSize;
        gp.monster[mapNum][14].worldY=20*gp.tileSize;

        gp.monster[mapNum][15]=new MON_Vipers(gp);
        gp.monster[mapNum][15].worldX=6*gp.tileSize;
        gp.monster[mapNum][15].worldY=6*gp.tileSize;

        gp.monster[mapNum][16]=new MON_Vipers(gp);
        gp.monster[mapNum][16].worldX=13*gp.tileSize;
        gp.monster[mapNum][16].worldY=5*gp.tileSize;

        gp.monster[mapNum][17]=new MON_Vipers(gp);
        gp.monster[mapNum][17].worldX=8*gp.tileSize;
        gp.monster[mapNum][17].worldY=6*gp.tileSize;

        gp.monster[mapNum][18]=new MON_Vipers(gp);
        gp.monster[mapNum][18].worldX=2*gp.tileSize;
        gp.monster[mapNum][18].worldY=5*gp.tileSize;

        gp.monster[mapNum][19]=new MON_Vipers(gp);
        gp.monster[mapNum][19].worldX=10*gp.tileSize;
        gp.monster[mapNum][19].worldY=5*gp.tileSize;
    }
}
