package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Slow extends Entity {
    public OBJ_Slow(GamePanel gp){
        super(gp);
        name="Slow";
        down1=setup("/objects/Slow",gp.tileSize,gp.tileSize);
        }
    }

