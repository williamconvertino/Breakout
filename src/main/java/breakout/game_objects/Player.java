package breakout.game_objects;

import breakout.Main;
import breakout.other_handlers.IOHandler;
import javafx.scene.input.KeyCode;

public class Player extends GameObjectControlled {

    //Constructors
    public Player(String textureName, double xpos, double ypos) {
        super(textureName, xpos, ypos);
    }

    public Player(String textureName) {
        this(textureName, 0, 0);
        this.setDefaultPosition();
        this.maxSpeed = 30;
        this.minSpeed = 30;
    }

    //Methods
    public void setDefaultPosition() {
        this.centerOnX();
        this.ypos = (Main.SCREEN_HEIGHT * 9.0) / 10;
    }

    private void moveWithInput(IOHandler ioHandler) {
        this.xvel = (ioHandler.isDown(KeyCode.LEFT) || ioHandler.isDown(KeyCode.A)? -1 * minSpeed : 0)  + (ioHandler.isDown(KeyCode.RIGHT) || ioHandler.isDown(KeyCode.D)? minSpeed : 0);
        move();
    }

    @Override
    public void update(IOHandler ioHandler) {
        moveWithInput(ioHandler);
    }

}
