package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Bomb extends Entity {
    public OBJ_Bomb(GamePanel gp){
        super(gp);
        name="Bomb";
        down1=setup("/objects/Bomb",gp.tileSize,gp.tileSize);
    }
}
