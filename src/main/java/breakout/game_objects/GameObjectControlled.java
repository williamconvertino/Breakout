package breakout.game_objects;

import breakout.other_handlers.IOHandler;

public class GameObjectControlled extends GameObjectTangible {

    public GameObjectControlled(String textureName, double xpos, double ypos, double xvel, double yvel) {
        super(textureName, xpos, ypos, xvel, yvel);
    }

    public GameObjectControlled(String textureName, double xpos, double ypos) {
        super(textureName, xpos, ypos);
    }




    private void moveWithInput(IOHandler ioHandler) {
         move();
    }


    public void update(IOHandler ioHandler) {
        moveWithInput(ioHandler);
    }


}
