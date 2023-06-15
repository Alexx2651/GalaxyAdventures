package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Speed extends Entity {
    public OBJ_Speed(GamePanel gp){
        super(gp);
        name="Speed";
        down1=setup("/objects/Speed",gp.tileSize,gp.tileSize);
    }
}
