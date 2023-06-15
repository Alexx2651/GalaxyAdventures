package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_BetasShot extends Projectile {
    GamePanel gp;

    public OBJ_BetasShot(GamePanel gp) {
        super(gp);
        this.gp=gp;
        name="bshoot";
        speed=5;
        maxLife=150;
        life=maxLife;
        attack=1;
        alive=false;
        getImage();
    }
    public void getImage(){
        up1=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        up2=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        down1=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        down2=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        left1=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        left2=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        right1=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);
        right2=setup("/Projectile/BetasShot",gp.tileSize,gp.tileSize);

    }
}
