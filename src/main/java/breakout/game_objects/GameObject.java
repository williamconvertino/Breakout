package breakout.game_objects;

import static java.lang.Math.sqrt;

import breakout.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject {

    //GameObject Variables
    protected double xpos,ypos;
    protected double xvel, yvel;
    protected double width, height;
    protected boolean isInactive;
    protected ImageView texture;
    protected double minSpeed;
    protected double maxSpeed;


    //Constructors
    public GameObject(String textureName, double xpos, double ypos, double xvel, double yvel) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.xvel = xvel;
        this.yvel = yvel;
        this.minSpeed = 0;
        this.maxSpeed = 0;
        generateTextureFromName(textureName);
    }

    public GameObject(String textureName, double xpos, double ypos) {
        this(textureName, xpos, ypos, 0, 0);
    }

    public GameObject(String textureName) {
        this(textureName, 0, 0, 0, 0);
    }

    //Methods
    private void generateTextureFromName(String name) {
        Image foundImage = new Image(name);
        texture = new ImageView(foundImage);
        this.width = foundImage.getWidth();
        this.height = foundImage.getHeight();
    }

    public void scaleTexture(double scale,double offsetX,double offsetY) {
        texture.setFitWidth(width * scale);
        texture.setFitHeight(height * scale);
        texture.setX((xpos * scale) + offsetX);
        texture.setY((ypos * scale) + offsetY);
    }


    public void centerOnX() {
        this.xpos = (Main.SCREEN_WIDTH - width)/2;
    }

    public void centerOnY() {
        this.ypos = (Main.SCREEN_HEIGHT - height)/2;
    }

    public void center() {
        centerOnX();
        centerOnY();
    }

    protected void enforceWindowBounds() {
        enforceTopBound();
        enforceBottomBound();
        enforceLeftBound();
        enforceRightBound();
    }

    protected void enforceTopBound() {
        if (ypos < 0) {
            ypos = 0;
        }
    }

    protected void enforceBottomBound() {
        if (ypos + height > Main.SCREEN_HEIGHT) {
            ypos = Main.SCREEN_HEIGHT - height;
        }
    }

    protected void enforceLeftBound() {
        if (xpos < 0) {
            xpos = 0;
        }
    }

    protected void enforceRightBound() {
        if (xpos + width > Main.SCREEN_WIDTH) {
            xpos = Main.SCREEN_WIDTH - width;
        }
    }

    protected void move() {
        verifySpeed();
        this.xpos += this.xvel;
        this.ypos += this.yvel;
        enforceWindowBounds();
    }

    public double getSpeed() {
        return(sqrt((xvel * xvel) + (yvel * yvel)));
    }

    protected void verifySpeed() {
        double speed = getSpeed();
        if (speed == 0) {return;}
        if (speed > maxSpeed) {
            xvel = maxSpeed * (xvel/speed);
            yvel = maxSpeed * (yvel/speed);
        }
        if (speed < minSpeed) {
            xvel = minSpeed * (xvel/speed);
            yvel = minSpeed * (yvel/speed);
        }
    }

    public void update() {

    }

    //Setter & Getter
    public double getXpos() {
        return xpos;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }

    public double getXvel() {
        return xvel;
    }

    public void setXvel(double xvel) {
        this.xvel = xvel;
    }

    public double getYvel() {
        return yvel;
    }

    public void setYvel(double yvel) {
        this.yvel = yvel;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isInactive() {
        return isInactive;
    }

    public void setInactive(boolean inactive) {
        isInactive = inactive;
    }

    public ImageView getTexture() {
        return texture;
    }

    public void setTexture(ImageView texture) {this.texture = texture;}
}
