package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_goldCoin extends Entity {
    GamePanel gp;
    public OBJ_goldCoin(GamePanel gp) {
        super(gp);
        this.gp=gp;
        type=type_pickUpOnly;
        name="Gold coin";
        down1=setup("/objects/gold coin",gp.tileSize,gp.tileSize);
    }
    public void use(Entity entity){
        gp.player.coin+=1;
        gp.player.score +=5;
    }
}
