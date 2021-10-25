package breakout.other_handlers;

import breakout.game_object_handlers.GameObjectHandler;
import breakout.game_objects.Background;
import javafx.scene.Group;

public class BackgroundHandler extends GameObjectHandler {


    //Constructors
    public BackgroundHandler(Group displayGroup) {
        super(displayGroup);
        resetToDefault();
    }

    //Methods
    public void resetToDefault() {
        addObject(new Background("Sky_Background.png"));
    }
}
