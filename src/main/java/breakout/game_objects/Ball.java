package breakout.game_objects;

import breakout.Main;

public class Ball extends GameObjectTangible {

    //Constructors
    public Ball(String textureName, double xpos, double ypos, double xvel, double yvel) {
        super(textureName, xpos, ypos, xvel, yvel);
        this.minSpeed = 20;
        this.maxSpeed = 30;
    }

    public Ball(String textureName, double xpos, double ypos) {
        this(textureName, xpos, ypos, 0, 0);
    }

    //Methods
    @Override
    public void interactWith(GameObjectTangible object) {
        if ((ypos < object.getYpos() && ypos + height > object.getYpos()) || (ypos < object.getYpos() + object.getHeight() && ypos + height > object.getYpos() + object.getHeight()))  {
            yvel = yvel * -1;
        }
        if ((xpos < object.getXpos() && xpos + width > object.getXpos()) || (xpos < object.getXpos() + object.getWidth() && xpos + width > object.getXpos() + object.getWidth())) {
            xvel = xvel * -1;
        }
        boundOut(object);
    }

    @Override
    protected void enforceTopBound() {
        if (ypos < 0) {
            ypos = 0;
            this.yvel = -1 * yvel;
        }
    }

    @Override
    protected void enforceBottomBound() {
        if (ypos + height > Main.SCREEN_HEIGHT) {
            ypos = Main.SCREEN_HEIGHT - height;
            this.yvel = -1 * yvel;
            this.isInactive = true;
        }

    }

    @Override
    protected void enforceLeftBound() {
        if (xpos < 0) {
            xpos = 0;
            this.xvel = -1 * xvel;
        }
    }

    @Override
    protected void enforceRightBound() {
        if (xpos + width > Main.SCREEN_WIDTH) {
            xpos = Main.SCREEN_WIDTH - width;
            this.xvel = -1 * xvel;
        }
    }

    public void update() {
        move();
    }

}
