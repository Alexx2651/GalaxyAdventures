package entity;

import main.GamePanel;
import main.KeyHandler;
import object.OBJ_Fireball;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    private Connection connection;
    String dbFilePath = "db/tiobe.db";
    String absolutePath = new File(dbFilePath).getAbsolutePath();

    public Player(GamePanel gp,KeyHandler keyH)
    {
        super(gp);
        this.gp=gp;
        this.keyH=keyH;

        attack=1;

        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);

        solidArea=new Rectangle(8,16,gp.tileSize-16,gp.tileSize-16);
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;

        solidArea.width=32;
        solidArea.height=32;

        attackArea.width=36;
        attackArea.height=36;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + absolutePath);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }
    public void setDefaultValues(){
        worldX=gp.tileSize*8;
        worldY=gp.tileSize*60;
        speed=4;
        direction="up";

        //PLAYER STATUS

        maxLife=12;
        life=maxLife;
        projectile=new OBJ_Fireball(gp);
    }
    public void getPlayerImage()
    {
        try{
            eu1= setup("/player/eu_1 (1)",gp.tileSize,gp.tileSize);
            eu2= setup("/player/eu_1 (2)",gp.tileSize,gp.tileSize);
            eu3= setup("/player/eu_1 (3)",gp.tileSize,gp.tileSize);
            eu4= setup("/player/eu_1 (4)",gp.tileSize,gp.tileSize);
            eu5= setup("/player/eu_1 (5)",gp.tileSize,gp.tileSize);
            eu6= setup("/player/eu_1 (6)",gp.tileSize,gp.tileSize);
            eu7= setup("/player/eu_1 (7)",gp.tileSize,gp.tileSize);
            eu8= setup("/player/eu_1 (8)",gp.tileSize,gp.tileSize);
            eu9= setup("/player/eu_1 (9)",gp.tileSize,gp.tileSize);
            eu10=setup("/player/eu_1 (10)",gp.tileSize,gp.tileSize);
            bg= ImageIO.read(getClass().getResourceAsStream("/player/BG.png"));
            bg1= ImageIO.read(getClass().getResourceAsStream("/player/BG1.png"));
            bg2= ImageIO.read(getClass().getResourceAsStream("/player/BG2.png"));
            boss= ImageIO.read(getClass().getResourceAsStream("/player/Boss.png"));
            exp0=setup("/player/exp0",gp.tileSize,gp.tileSize);
            exp1=setup("/player/exp1",gp.tileSize,gp.tileSize);
            exp2=setup("/player/exp2",gp.tileSize,gp.tileSize);
            exp3=setup("/player/exp3",gp.tileSize,gp.tileSize);
            exp4=setup("/player/exp4",gp.tileSize,gp.tileSize);
            exp5=setup("/player/exp5",gp.tileSize,gp.tileSize);
            exp6=setup("/player/exp6",gp.tileSize,gp.tileSize);
            exp7=setup("/player/exp7",gp.tileSize,gp.tileSize);
            exp8=setup("/player/exp8",gp.tileSize,gp.tileSize);
        }catch (IOException E){
            E.printStackTrace();
        }

    }
    public void getPlayerAttackImage(){
        attackUp1=setup("/player/atac",gp.tileSize,gp.tileSize);
        attackUp2=setup("/player/atac1",gp.tileSize,gp.tileSize);
    }
    public void update() {
        isAttacking();
        if(attacking==true)
        {
            attacking();
        }
        else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true ||
                keyH.rightPressed == true) {
            if (keyH.upPressed) {

                direction = "up";
                // worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                //worldY+=speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                //worldX-=speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                //worldX+=speed;
            }


            //check tile collision
            collisionON = false;
            gp.cChecker.checkTile(this);
            //check object collision
            int objIndex=gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            //CHECK MONSTER COLISION
            int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
            contactMonster(monsterIndex);
            if(life<=0){
                gp.gameState=gp.gameOverState;
            }

            if (collisionON == false&&dead==false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            //CHECK EVENT
            gp.eHandler.checkEvent();
        }

        if(gp.keyH.shootKeyPressed==true){
            //SET DEFAULT COORDINATES,DIRECTION AND USER
            projectile.set(worldX,worldY,direction,true,this);
            //ADD IT TO THE LIST
            gp.projectileList.add(projectile);
        }
        spritrCounter++;
        if(spritrCounter>15)
        {
            switch(spriteNum){
                case 1:
                    spriteNum=2;
                    break;
                case 2:
                    spriteNum=3;
                    break;
                case 3:
                    spriteNum=4;
                    break;
                case 4:
                    spriteNum=5;
                    break;
                case 5:
                    spriteNum=6;
                    break;
                case 6:
                    spriteNum=7;
                    break;
                case 7:
                    spriteNum=8;
                    break;
                case 8:
                    spriteNum=9;
                    break;
                case 9:
                    spriteNum=1;
                    break;
            }
        }
        if(life<=0){
            dead=true;
            gp.gameState=gp.gameOverState;
        }
    }
    public void attacking(){

        spritrCounter++;
        if(spritrCounter<=5){
            spriteNum=1;
        }
        if(spritrCounter>5&&spritrCounter<=25){
            spriteNum=2;

            //save the current WorldX,worldY,solid area
            int currentWorldX=worldX;
            int currentWorldY=worldY;
            int solidAreaWidth=solidArea.width;
            int solidAreaHeight=solidArea.height;

            switch(direction){
                case "up":
                    worldY-=attackArea.height;
                    break;
                case "down":
                    worldY+= gp.tileSize;
                    break;
                case "left":
                    worldX-=attackArea.width;
                    break;
                case "right":
                    worldX+= gp.tileSize;
                    break;
            }
            //attack area becomes solid area
            solidArea.width=attackArea.width;
            solidArea.height=attackArea.height;
            //check monster colission with updated parameters
            int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
            damageMonster(monsterIndex,attack);
            //restore the original parameters
            worldX=currentWorldX;
            worldY=currentWorldY;
            solidArea.width=solidAreaWidth;
            solidArea.height=solidAreaHeight;
        }
        if(spritrCounter>25){
            spriteNum=1;
            spritrCounter=0;
            attacking=false;
        }

    }
    public void isAttacking(){
        if(keyH.spacePressed==true){
            attacking=true;
        }
    }
    public void pickUpObject(int i){
        if(i!=999){
            String objectName=gp.obj[gp.currentMap][i].name;
            if(gp.obj[gp.currentMap][i].type==type_pickUpOnly){
                gp.obj[gp.currentMap][i].use(this);
                gp.obj[gp.currentMap][i]=null;
            }
            switch (objectName){
                case "Speed":
                    gp.player.speed+=1;
                    gp.obj[gp.currentMap][i]=null;
                    break;
                case "BonusHP":
                    gp.player.life=maxLife;
                    gp.obj[gp.currentMap][i]=null;
                    break;
                case "Bomb":
                    gp.player.life-=1;
                    gp.obj[gp.currentMap][i]=null;
                    break;
                case "Dmg":
                    gp.player.attack+=2;
                    gp.obj[gp.currentMap][i]=null;
                    break;
            }



            }
        }
    public void contactMonster(int i){
        if(i!=999){
            life-=1;
            dead=true;
        }
    }
    public void damageMonster(int i,int attack){
        if(i!=999){
            if(gp.monster[gp.currentMap][i].invincible==false){
                int damage=attack-gp.monster[gp.currentMap][i].defense;
                if(damage<0){damage=0;}
                gp.monster[gp.currentMap][i].life-=damage;
                gp.monster[gp.currentMap][i].invincible=true;
                if(gp.monster[gp.currentMap][i].life<=0){
                    gp.monster[gp.currentMap][i].alive=false;
                    score+=10;
                }
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        // DEBUG
        // AttackArea
//        int tempScreenX = screenX + solidArea.x;
//        int tempScreenY = screenY + solidArea.y;
//        switch(direction) {
//            case "up": tempScreenY = screenY - attackArea.height; break;
//            case "down": tempScreenY = screenY + gp.tileSize; break;
//            case "left": tempScreenX = screenX - attackArea.width; break;
//            case "right": tempScreenX = screenX + gp.tileSize; break;
//        }
//        g2.setColor(Color.YELLOW);
//        g2.setStroke(new BasicStroke(1));
        //g2.drawRect(tempScreenX, tempScreenY, attackArea.width, attackArea.height);

        BufferedImage image=null;
        switch (direction){
            case "up", "down", "left", "right":
                if(attacking==false){
                    if(spriteNum==1){
                        image=eu1;
                    }
                    if(spriteNum==2){
                        image=eu2;
                    }
                    if(spriteNum==3){
                        image=eu3;
                    }
                    if(spriteNum==4){
                        image=eu4;
                    }
                    if(spriteNum==5){
                        image=eu5;
                    }
                    if(spriteNum==6){
                        image=eu6;
                    }
                    if(spriteNum==7){
                        image=eu7;
                    }
                    if(spriteNum==8){
                        image=eu8;
                    }
                    if(spriteNum==9){
                        image=eu9;
                    }
                    if(spriteNum==10){
                        image=eu10;
                    }
                }
                if(attacking==true){
                    if(spriteNum==1){image=attackUp1;}
                    if(spriteNum==2){image=attackUp2;}
                }

                break;
        }

        if(dead==true){
            BufferedImage[] images={exp0,exp1,exp2,exp3,exp4,exp5,exp6,exp7,exp8};
            int interval=100;
            int currentIndex=(int)((System.currentTimeMillis()/interval)%images.length);
            g2.drawImage(images[currentIndex],screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
        else{
            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
    }

    public void createScoresTable() {
        try {
            Statement statement = connection.createStatement();

//            String query = "DROP TABLE IF EXISTS scores";
//            statement.executeUpdate(query);
//            System.out.println("Table deleted successfully.");

             String query = "CREATE TABLE IF NOT EXISTS scores ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "currentMap INTEGER,"
                    + "worldX INTEGER,"
                    + "worldY INTEGER,"
                    + "score INTEGER"
                    + ")";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveScoresToDatabase() {
        try {
            String insertQuery = "INSERT INTO scores (currentMap, worldX, worldY, score) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

            insertStatement.setInt(1, gp.currentMap);
            insertStatement.setInt(2, worldX);
            insertStatement.setInt(3, worldY);
            insertStatement.setInt(4, score);

            // Execute the INSERT statement
            insertStatement.executeUpdate();

            // Close the statement
            insertStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
    public void loadScoresFromDatabase() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM scores ORDER BY id DESC LIMIT 1");

            if (resultSet.next()) {
                gp.currentMap = resultSet.getInt("currentMap");
                worldX = resultSet.getInt("worldX");
                worldY = resultSet.getInt("worldY");
                score = resultSet.getInt("score");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
