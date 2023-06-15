package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_BonusHp extends Entity {
    public OBJ_BonusHp(GamePanel gp){
        super(gp);
        name="BonusHP";
        down1=setup("/objects/HPBonus",gp.tileSize,gp.tileSize);
    }
}
