package breakout.game_object_handlers;

import breakout.game_objects.GameObject;
import breakout.game_objects.GameObjectControlled;
import breakout.other_handlers.IOHandler;
import breakout.other_handlers.WindowHandler;
import javafx.scene.Group;

public class GameObjectControlledHandler extends GameObjectTangibleHandler {


    //Constructors
    public GameObjectControlledHandler(Group displayGroup) {

        super(displayGroup);

    }

    public void update(WindowHandler windowHandler, IOHandler ioHandler) {
        for (GameObject o: objectList) {
            ((GameObjectControlled)o).update(ioHandler);
            windowHandler.scaleObject(o);
        }
    }

}
