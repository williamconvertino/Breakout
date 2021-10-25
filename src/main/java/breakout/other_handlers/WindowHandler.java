package breakout.other_handlers;

import breakout.Main;
import breakout.game_objects.GameObject;
import javafx.scene.Scene;

public class WindowHandler {


    //Variables
    private Scene gameScene;
    private double scale;
    private double offsetX, offsetY;

    //Constructors
    public WindowHandler(Scene gameScene) {
        this.gameScene = gameScene;
        this.scale = 1.0;
        this.offsetX = 0;
        this.offsetY = 0;
    }

    //Methods
    public void getWindowScaling() {

        double width = gameScene.getWidth();
        double height = gameScene.getHeight();

        //Find which window dimension is limiting, set scaling & offset accordingly
        if ( (width / Main.SCREEN_WIDTH) > (height / Main.SCREEN_HEIGHT) ) {
            scale = (height/Main.SCREEN_HEIGHT);
            offsetX = (int)((width - (Main.SCREEN_WIDTH * scale)) / 2.0);
            offsetY = 0;
        } else {
            scale = (width/Main.SCREEN_WIDTH);
            offsetY = (int)((height - (Main.SCREEN_HEIGHT * scale)) / 2.0);
            offsetX = 0;
        }

    }

    public void scaleObject(GameObject o) {
        getWindowScaling();
        o.scaleTexture(scale, offsetX, offsetY);
    }


}
