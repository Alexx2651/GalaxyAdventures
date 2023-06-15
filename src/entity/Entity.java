package entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    public String name;
    GamePanel gp;
    public Entity(GamePanel gp){
        this.gp=gp;
    }
    public int worldX,worldY;
    public int speed;

    public BufferedImage eu1,eu2,eu3,eu4,eu5,eu6,
            eu7,eu8,eu9,eu10,bg,boss,bg1,bg2;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public BufferedImage exp0,exp1,exp2,exp3,exp4,exp5,exp6,exp7,exp8;
    public BufferedImage attackUp1,attackUp2;
    public BufferedImage image,image2,image3;
    public String direction="down";
    public int spritrCounter=0;
    public int spriteNum=1;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public Rectangle attackArea=new Rectangle(0,0,0,0);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;
    public int maxLife;
    public int life;
    public int actionLockCounter=0;
    public int attack;
    public int defense;
    public Projectile projectile;
    public boolean alive=true;

    public boolean collisionON=false;

    public boolean dead=false;
    public boolean attacking=false;
    public boolean invincible=false;
    public boolean hpBarOn=false;
    public int hpBarCounter=0;
    public int shootingFreq;
    public int coin=0;

    public int score=0;
    public void checkDrop(){}
    public void dropItem(Entity droppedItem){
        for(int i=0;i<gp.obj[1].length;i++){
            if(gp.obj[gp.currentMap][i]==null){
                gp.obj[gp.currentMap][i]=droppedItem;
                gp.obj[gp.currentMap][i].worldX=worldX;//item gets dropped on the dead monster's coordinates
                gp.obj[gp.currentMap][i].worldY=worldY;
                break;//we break the loop so the droppedItem won't be put in every free slot found
            }
        }
    }
    public boolean collision=false;
    public int invincibleCounter=0;
    public int type;// Betas=0
    public final int type_pickUpOnly=1;
    public void setAction(){}
    public void use(Entity entity){}
    public void update(){

        setAction();
        use(this);

        collisionON=false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this, gp.monster);
        gp.cChecker.checkPlayer(this);

        if (collisionON == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        spritrCounter++;
        if(spritrCounter>12){
            if(spriteNum==1){
                spriteNum=2;
            }
            else if(spriteNum==2){
                spriteNum=1;
            }
            spritrCounter=0;
        }
        if(invincible==true){
            invincibleCounter++;
            if(invincibleCounter>40){
                invincible=false;
                invincibleCounter=0;
            }

        }

    }

    public void draw(Graphics2D g2){
        BufferedImage image=null;
        int screenX=worldX-gp.player.worldX+gp.player.screenX;
        int screenY=worldY-gp.player.worldY+gp.player.screenY;

        if(     worldX+gp.tileSize>gp.player.worldX-gp.player.screenX&&
                worldX-gp.tileSize<gp.player.worldX+gp.player.screenX&&
                worldY+gp.tileSize>gp.player.worldY-gp.player.screenY&&
                worldY-gp.tileSize<gp.player.worldY+gp.player.screenY)//to only load the tiles that we see on the screen
        {
            switch (direction){
                case"up":
                    if(spriteNum==1){
                        image=up1;
                    }
                    if(spriteNum==2){
                        image=up2;
                    }
                    break;
                case"down":
                    if(spriteNum==1){
                        image=down1;
                    }
                    if(spriteNum==2){
                        image=down2;
                    }
                    break;
                case"left":
                    if(spriteNum==1){
                        image=left1;
                    }
                    if(spriteNum==2){
                        image=left2;
                    }
                    break;
                case"right":
                    if(spriteNum==1){
                        image=right1;
                    }
                    if(spriteNum==2){
                        image=right2;
                    }
                    break;
            }
            if(type==0&&hpBarOn){
                double oneScale=(double)gp.tileSize/maxLife;
                double hpBarValue=oneScale*life;

                g2.setColor(new Color(35,35,35));
                g2.fillRect(screenX-1,screenY-16,gp.tileSize+2,12);

                g2.setColor(new Color(255,0,30));
                g2.fillRect(screenX,screenY-15,(int)hpBarValue,10);

                hpBarCounter++;
                if(hpBarCounter>600){
                    hpBarCounter=0;
                    hpBarOn=false;
                }
            }
            if(invincible==true){
                hpBarOn=true;
                hpBarCounter=0;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.4f));
            }

            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
        }
    }
    public BufferedImage setup(String imagePath,int width,int height){
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
