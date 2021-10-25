package breakout.game_object_handlers;

import breakout.game_objects.GameObject;
import breakout.other_handlers.WindowHandler;
import java.util.ArrayList;
import javafx.scene.Group;

public class GameObjectHandler {

    //Class Variables
    protected ArrayList<GameObject> objectList;
    protected Group displayGroup;

    //Constructors
    public GameObjectHandler(Group displayGroup) {
        this.displayGroup = displayGroup;
        objectList = new ArrayList();
    }

    //Methods
    public void addObject(GameObject gameObject) {
        objectList.add(gameObject);
        displayGroup.getChildren().add(gameObject.getTexture());
    }

    public void removeObject(GameObject gameObject) {

        objectList.remove(gameObject);
        displayGroup.getChildren().remove(gameObject);
    }

    public void clearInactiveObjects() {

        for (GameObject o: objectList) {
            if (o.isInactive()) {
                displayGroup.getChildren().remove(o.getTexture());
                //objectList.remove(o);
            }
        }
        objectList.removeIf(b->b.isInactive());

    }

    public void reset() {
        objectList.clear();
        resetToDefault();
    }

    public void resetToDefault() {

    }

    public ArrayList<GameObject> getObjectList() {
        return objectList;
    }

    public void update(WindowHandler windowHandler) {
        for (GameObject o: objectList) {
            o.update();
            windowHandler.scaleObject(o);
        }
    }

}
