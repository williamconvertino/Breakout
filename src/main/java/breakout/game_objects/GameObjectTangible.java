package breakout.game_objects;

import java.util.Random;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class GameObjectTangible extends GameObject {


    //Variables
    protected Shape hitbox;

    //Constructors
    public GameObjectTangible(String textureName, double xpos, double ypos, double xvel, double yvel) {
        super(textureName, xpos, ypos, xvel, yvel);
    }

    public GameObjectTangible(String textureName, double xpos, double ypos) {
        this(textureName, xpos, ypos, 0, 0);
    }

    //Methods
    public void defineHitbox() {
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    public void randomizeDirection() {
        randomizeDirection(1);
    }

    public void randomizeDirection(int allowPositiveY) {
        Random r = new Random();
        double speed =  getSpeed();
        double s = r.nextDouble() * speed;
        xvel = Math.abs(s) * (r.nextBoolean() ? 1 : -1);
        yvel = Math.abs(speed - s)  * (r.nextBoolean() ? allowPositiveY : -1);
        verifySpeed();
    }

    public void randomizeSpeed() {
        randomizeSpeed(minSpeed, maxSpeed);
    }

    public void randomizeSpeed(double minVel, double maxVel) {
        double vx = getSpeed() == 0? 1:xvel/getSpeed();
        double vy = getSpeed() == 0? 1:xvel/getSpeed();

        Random r = new Random();
        double scale = (minVel + (r.nextDouble() * (maxVel - minVel)));
        xvel = vx * scale;
        yvel = vy * scale;
        verifySpeed();
    }

    public void boundOut(GameObjectTangible object) {

        if (xpos <= object.getXpos() && xpos + width >= object.getXpos() ) {
            this.xpos = object.getXpos() - width;
        }
        if (xpos >= object.getXpos() + object.getWidth() && xpos <= object.getXpos()+object.getWidth()) {
            this.xpos = object.getXpos() + object.getWidth();
        }
        if (ypos <= object.getYpos() && ypos + height >= object.getYpos() ) {
            this.ypos = object.getYpos() - height;
        }
        if (ypos >= object.getYpos() + object.getHeight() && ypos <= object.getYpos()+object.getHeight()) {
            this.ypos = object.getYpos() + object.getHeight();
        }

    }


    public void interactWith(GameObjectTangible object) {

    }


    //Setter & Getter Methods

    public Shape getHitbox() {
        defineHitbox();
        return hitbox;
    }
}
