package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Entity {
    Entity user;

    public Projectile(GamePanel gp) {
        super(gp);
    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = maxLife;
    }

    public void update() {
        if(user==gp.player){
            int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
            if(monsterIndex!=999){
                gp.player.damageMonster(monsterIndex,attack);
                alive=false;
            }
            switch (direction) {
                case "up", "down", "left", "right":
                    worldY -= speed;
                    break;
            }
        }
        else{
            switch (direction) {
                case "up", "down", "left", "right":
                    worldY += speed;
                    break;
            }
            boolean contactPlayer=gp.cChecker.checkPlayer(this);
            if(contactPlayer){
                gp.player.life-=1;
                alive=false;
            }

        }
        life--;
        if (life <= 0) {
            alive = false;
        }
        spritrCounter++;
        if (spritrCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spritrCounter = 0;
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)//to only load the tiles that we see on the screen
        {
            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;
            }
            g2.drawImage(image, screenX+16, screenY, gp.tileSize/2, gp.tileSize/2, null);
        }
    }
}
