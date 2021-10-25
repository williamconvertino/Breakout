package breakout;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    //Program Variables
    public static final String TITLE = "Breakout XTREME";
    public static final int SCREEN_WIDTH = 1920;
    public static final int SCREEN_HEIGHT = 1080;
    public static final int FPS = 60;
    public static final double ONE_SECOND_DELAY = 1.0 / FPS;
    public static final Paint BACKGROUND_COLOR = Color.rgb(30,30,30);

    //JavaFX Variables
    private Scene gameScene;
    private Timeline gameTimeline;
    private Group displayGroup;
    private BreakoutHandler breakoutHandler;



    //Starts the application
    @Override
    public void start(Stage stage) {

        initializeGameEnvironment(stage);
        initializeMusic();
        initializeTimeline();
        initializeBreakoutHandler();

    }

    //Initializes the game environment
    private void initializeGameEnvironment (Stage stage) {

        displayGroup = new Group();
        gameScene = new Scene(displayGroup, .6 * SCREEN_WIDTH,.6 * SCREEN_HEIGHT,  BACKGROUND_COLOR);
        stage.setScene(gameScene);
        stage.setTitle(TITLE);
        stage.show();

    }

    //Initializes the timeline and game update loop
    public void initializeTimeline() {
        gameTimeline = new Timeline();
        gameTimeline.setCycleCount(Timeline.INDEFINITE);
        gameTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(ONE_SECOND_DELAY), e -> {update();}));
        gameTimeline.play();
    }

    //Initializes the music
    public void initializeMusic(){
        String songURL = getClass().getResource( "/playme.mp3").toExternalForm();
        MediaPlayer song = new MediaPlayer(new Media(songURL));
        song.setCycleCount(MediaPlayer.INDEFINITE);
        song.play();
    }

    public void initializeBreakoutHandler() {
        this.breakoutHandler = new BreakoutHandler(displayGroup, gameScene);
    }

    public void update() {
        breakoutHandler.update();
    }

}
