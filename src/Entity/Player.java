package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage image;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2  - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(0, 0, 20, 20);

        setDefaultValues();
        getPlayerImage();
        image = down1;
    }

    public void setDefaultValues(){
        worldX = 100;
        worldY = 100;
        speed = 3;
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/neutralNorth.PNG")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/leftNorth.PNG")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/rightNorth.PNG")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/neutralSouth.PNG")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/leftSouth.PNG")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/rightSouth.PNG")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/neutralWest.PNG")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/leftWest.PNG")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/rightWest.PNG")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/neutralEast.PNG")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/leftEast.PNG")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/resources/player/rightEast.PNG")));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    //ATTEMPTED PRIMARY IMAGE SWITCHER MECHANISM.
        //FAILED***

//    public void testForImageChange(){
//        switch(direction){
//            case "up":
//                if(movementTick == 10 || movementTick == 20)
//                    image = up1;
//                else if(movementTick == 5)
//                    image = up2;
//                else if(movementTick == 15)
//                    image = up3;
//                break;
//            case "down":
//                if(movementTick == 10 || movementTick == 20)
//                    image = down1;
//                else if(movementTick == 5)
//                    image = down2;
//                else if (movementTick == 15)
//                    image = down3;
//                break;
//            case "left":
//                if(movementTick == 10 || movementTick == 20)
//                    image = left1;
//                else if(movementTick == 5)
//                    image = left2;
//                else if(movementTick == 15)
//                    image = left3;
//                break;
//            case "right":
//                if(movementTick == 10|| movementTick == 20)
//                    image = right1;
//                else if(movementTick == 5)
//                    image = right2;
//                else if(movementTick == 15)
//                    image = right3;
//                break;
//        }
//    }

    public void testForImageChange(){
        if(direction.equals("up")) {
            if (movementTick == 10 || movementTick == 20)
                image = up1;
            else if (movementTick == 5)
                image = up2;
            else if (movementTick == 15)
                image = up3;
        } else if(direction.equals("down")) {
            if (movementTick == 10 || movementTick == 20)
                image = down1;
            else if (movementTick == 5)
                image = down2;
            else if (movementTick == 15)
                image = down3;
        } else if(direction.equals("left")) {
            if (movementTick == 10 || movementTick == 20)
                image = left1;
            else if (movementTick == 5)
                image = left2;
            else if (movementTick == 15)
                image = left3;
        } else if(direction.equals("right")) {
            if (movementTick == 10 || movementTick == 20)
                image = right1;
            else if (movementTick == 5)
                image = right2;
            else if (movementTick == 15)
                image = right3;
        }
        if(movementTick > 20)
            movementTick = 0;
    }

    public void update(){

        if(keyH.upPressed){
            direction = "up";
            movementTick++;
        } else if(keyH.downPressed){
            direction = "down";
            movementTick++;
        } else if(keyH.leftPressed){
            direction = "left";
            movementTick++;
        } else if(keyH.rightPressed) {
            direction = "right";
            movementTick++;
        }  else {direction = "null";}

        //Test Collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        if(!collisionOn){
            switch(direction){
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

        testForImageChange();
    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
