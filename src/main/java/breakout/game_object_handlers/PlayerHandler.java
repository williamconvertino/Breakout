package breakout.game_object_handlers;

import breakout.game_objects.Player;
import javafx.scene.Group;

public class PlayerHandler extends GameObjectControlledHandler {

    public PlayerHandler(Group displayGroup) {
        super(displayGroup);
    }

    @Override
    public void resetToDefault() {
        addObject(new Player("Guide_Bar.png"));

    }

}
