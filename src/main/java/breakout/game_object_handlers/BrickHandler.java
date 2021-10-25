package breakout.game_object_handlers;


import breakout.game_objects.Brick;
import breakout.game_objects.BrickTypes;
import breakout.game_objects.GameObjectTangible;
import breakout.other_handlers.WindowHandler;
import java.util.ArrayList;
import javafx.scene.Group;

public class BrickHandler extends GameObjectTangibleHandler {

    //Constructors
    public BrickHandler(Group displayGroup) {
        super(displayGroup);
    }



    //Methods
    @Override
    public void resetToDefault() {
        makeTestingBrickLayout();
    }

    public void makeTestingBrickLayout() {
        for (int y = 10; y < 600; y+= 140) {
            for (int x = 10; x < 1800 ; x += 270) {
                addObject(new Brick(x,y, BrickTypes.BASIC_BLUE));
            }
        }
    }

    public void update(WindowHandler windowHandler, ArrayList<GameObjectTangible> ballList) {

        for (GameObjectTangible o: getObjectListTangible()) {
            o.update();
            for (GameObjectTangible b: ballList) {
                if (isIntersecting(o,b)) {
                    checkInteraction(o,b);
                }
            }
            windowHandler.scaleObject(o);
        }
    }
}
