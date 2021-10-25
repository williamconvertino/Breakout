package breakout.game_object_handlers;


import breakout.Main;
import breakout.game_objects.Ball;
import breakout.game_objects.GameObject;
import breakout.game_objects.GameObjectTangible;
import breakout.other_handlers.WindowHandler;
import java.util.ArrayList;
import javafx.scene.Group;

public class BallHandler extends GameObjectTangibleHandler {

    //Variables
    private int ballsRemovedThisCycle;

    //Constructor
    public BallHandler(Group displayGroup) {
        super(displayGroup);
        this.ballsRemovedThisCycle = 0;
    }


    //Methods
    @Override
    public void resetToDefault() {
        this.ballsRemovedThisCycle = 0;
        addRandomBall(-1);
    }

    @Override
    public void clearInactiveObjects() {
        this.ballsRemovedThisCycle = 0;
        for (GameObject o: objectList) {
            if (o.isInactive()) {
                displayGroup.getChildren().remove(o.getTexture());
                ballsRemovedThisCycle += 1;
            }
        }
        objectList.removeIf(b->b.isInactive());
    }


    public void addRandomBall(int allowPositiveY) {
        Ball b = new Ball("Stone_Ball.png", 0, (Main.SCREEN_HEIGHT * 8) / 10);
        b.centerOnX();
        b.randomizeSpeed();
        b.randomizeDirection(allowPositiveY);
        addObject(b);
    }

    public int getBallsRemovedThisCycle() {
        return ballsRemovedThisCycle;
    }

    public void update(WindowHandler windowHandler, ArrayList<GameObjectTangible> playerList) {
        for (GameObjectTangible o: getObjectListTangible()) {
            o.update();
            for (GameObjectTangible p: playerList) {
                if (isIntersecting(o,p)) {
                    checkInteraction(o,p);
                }
            }
            windowHandler.scaleObject(o);
        }
    }
}
