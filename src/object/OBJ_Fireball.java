package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile {
    GamePanel gp;

    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        this.gp=gp;
        name="Fireball";
        speed=10;
        maxLife=800;
        life=maxLife;
        if(gp.currentMap==0){
            attack=2;
        }
        else if(gp.currentMap==1){
            attack=3;
        }
        else if(gp.currentMap==2){
            attack=4;
        }
        alive=false;
        getImage();
    }
    public void getImage(){
        up1=setup("/Projectile/shoot",gp.tileSize/2,gp.tileSize/2);
        up2=setup("/Projectile/shoot",gp.tileSize/2,gp.tileSize/2);
        down1=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
        down2=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
        left1=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
        left2=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
        right1=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
        right2=setup("/Projectile/shoot",gp.tileSize,gp.tileSize);
    }


}
