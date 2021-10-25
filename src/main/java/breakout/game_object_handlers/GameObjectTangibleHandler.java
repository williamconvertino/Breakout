package breakout.game_object_handlers;

import breakout.game_objects.GameObjectTangible;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.shape.Shape;

public class GameObjectTangibleHandler extends GameObjectHandler {

    //Constructor
    public GameObjectTangibleHandler(Group displayGroup) {
        super(displayGroup);
    }

    //Methods
    public boolean isIntersecting(GameObjectTangible objectA, GameObjectTangible objectB) {
        return(!Shape.intersect(objectA.getHitbox(),objectB.getHitbox()).getBoundsInLocal().isEmpty());
    }

    public ArrayList<GameObjectTangible> getObjectListTangible() {
        return (ArrayList<GameObjectTangible>)(List<?>)objectList;
    }

    public void checkInteraction(GameObjectTangible objectA, GameObjectTangible objectB) {
        if (isIntersecting(objectA, objectB)) {
            objectA.defineHitbox();
            objectB.defineHitbox();
            objectA.interactWith(objectB);
            objectB.interactWith(objectA);
        }
    }

}
