package monster;
import entity.Entity;
import main.GamePanel;
import object.OBJ_BetasShot;
import object.OBJ_goldCoin;
import object.OBJ_mobShot;

import java.util.Random;

public class MON_Cristalions extends Entity {
    GamePanel gp;

    public MON_Cristalions(GamePanel gp) {
        super(gp);
        this.gp = gp;

        direction = "left";
        name = "Cristalions";
        speed = 2;
        maxLife = 8;
        defense = 0;
        life = maxLife;
        type = 0;
        shootingFreq=20;
        //alive=true;
        projectile = new OBJ_mobShot(gp);

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 58;
        solidArea.height = 46;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("/monsters/Cristalions1", gp.tileSize, gp.tileSize);
        up2 = setup("/monsters/Cristalions2", gp.tileSize, gp.tileSize);
        down1 = setup("/monsters/Cristalions1", gp.tileSize, gp.tileSize);
        down2 = setup("/monsters/Cristalions2", gp.tileSize, gp.tileSize);
        left1 = setup("/monsters/Cristalions1", gp.tileSize, gp.tileSize);
        left2 = setup("/monsters/Cristalions2", gp.tileSize, gp.tileSize);
        right1 = setup("/monsters/Cristalions1", gp.tileSize, gp.tileSize);
        right2 = setup("/monsters/Cristalions2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {

        actionLockCounter++;

        if (actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 50) {
                direction = "right";
            }
            if (i > 50) {
                direction = "left";
            }
            actionLockCounter = 0;
        }
        int j = new Random().nextInt(100) + 1;
        if (j > shootingFreq && projectile.alive == false) {
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
        }
    }
    public void checkDrop(){
        int i=new Random().nextInt(100)+1;
        //SET THE MONSTER DROP
        if(i<60){
            dropItem(new OBJ_goldCoin(gp));
        }
    }
}

