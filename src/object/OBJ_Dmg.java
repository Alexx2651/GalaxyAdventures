package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Dmg extends Entity {

    public OBJ_Dmg(GamePanel gp){
        super(gp);
        name="Dmg";
        down1=setup("/objects/DmgBonus",gp.tileSize,gp.tileSize);
    }

}
