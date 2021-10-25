package breakout;

import breakout.game_object_handlers.BallHandler;
import breakout.game_object_handlers.BrickHandler;
import breakout.game_object_handlers.PlayerHandler;
import breakout.game_objects.Background;
import breakout.other_handlers.BackgroundHandler;
import breakout.other_handlers.GameStateHandler;
import breakout.other_handlers.IOHandler;
import breakout.other_handlers.WindowHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BreakoutHandler {


    //Variables
    private final Group displayGroup;
    private final Scene gameScene;
    //Handler Variables
    private GameStateHandler gameStateHandler;
    private IOHandler ioHandler;
    private WindowHandler windowHandler;
    private PlayerHandler playerHandler;
    private BallHandler ballHandler;
    private BrickHandler brickHandler;
    private BackgroundHandler backgroundHandler;


    //Constructors
    public BreakoutHandler(Group displayGroup, Scene gameScene) {
        this.displayGroup = displayGroup;
        this.gameScene = gameScene;
        initializeHandlers();
        restartGame();
    }

    //Methods
    private void initializeHandlers() {
        this.gameStateHandler = new GameStateHandler();
        this.ioHandler = new IOHandler(gameScene);
        this.windowHandler = new WindowHandler(gameScene);
        this.playerHandler = new PlayerHandler(displayGroup);
        this.ballHandler = new BallHandler(displayGroup);
        this.brickHandler = new BrickHandler(displayGroup);
        this.backgroundHandler = new BackgroundHandler(displayGroup);
    }

    private void restartGame() {
        displayGroup.getChildren().clear();
        backgroundHandler.reset();
        gameStateHandler.resetToDefault();
        playerHandler.reset();
        ballHandler.reset();
        brickHandler.reset();
    }

    private void checkIO() {
        if (ioHandler.isPressed(KeyCode.R)) {
            restartGame();
        }
        if (ioHandler.isPressed(KeyCode.Y)) {
            ballHandler.addRandomBall(-1);
        }
    }

    private void updateLives () {
        gameStateHandler.removeLives(ballHandler.getBallsRemovedThisCycle());
    }

    private void checkGameState() {
        if (gameStateHandler.getLives() <= 0 && gameStateHandler.getGameState() == 0) {
            gameStateHandler.setGameState(-1);
            loseGame();
        } else if (brickHandler.getObjectList().size() == 0 && gameStateHandler.getGameState() == 0) {
            gameStateHandler.setGameState(1);
            winGame();
        }

    }

    private void loseGame() {
        Background loseMessage = new Background("Game_Over_Lose.png");
        loseMessage.center();
        backgroundHandler.addObject(loseMessage);

    }


    private void winGame() {
        Background winMessage = new Background("You_Win.png");
        winMessage.center();
        backgroundHandler.addObject(winMessage);
    }

    private void updateHandlers() {
        playerHandler.update(windowHandler, ioHandler);
        ballHandler.update(windowHandler, playerHandler.getObjectListTangible());
        brickHandler.update(windowHandler, ballHandler.getObjectListTangible());
        backgroundHandler.update(windowHandler);
        gameStateHandler.update();
        ioHandler.update();
    }

    private void clearHandlers() {
        playerHandler.clearInactiveObjects();
        ballHandler.clearInactiveObjects();
        brickHandler.clearInactiveObjects();
        backgroundHandler.clearInactiveObjects();
    }

    public void update() {
        checkIO();
        updateHandlers();
        clearHandlers();

        updateLives();
        checkGameState();

    }

}
