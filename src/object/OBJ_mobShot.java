package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_mobShot extends Projectile {
    GamePanel gp;

    public OBJ_mobShot(GamePanel gp) {
        super(gp);
        this.gp=gp;
        name="mshoot";
        speed=8;
        maxLife=150;
        life=maxLife;
        attack=2;
        alive=false;
        getImage();
    }
    public void getImage(){
        up1=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        up2=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        down1=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        down2=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        left1=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        left2=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        right1=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);
        right2=setup("/Projectile/MobShot",gp.tileSize,gp.tileSize);

    }
}
