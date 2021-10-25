package breakout.other_handlers;

import java.util.HashSet;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class IOHandler {

    //Variables

    //Game Variables
    private Scene gameScene;

    //IO Variables
    private HashSet<KeyCode> keyDown;
    private HashSet<KeyCode> keyPressed;
    private double mouseX, mouseY;
    private boolean mouseClicked;


    //Constructors
    public IOHandler(Scene gameScene) {
        this.gameScene = gameScene;
        this.keyDown = new HashSet();
        this.keyPressed = new HashSet();
        eventHandlerSetup();
    }

    public void eventHandlerSetup() {
        gameScene.setOnKeyPressed(e -> keyPressed(e.getCode()));
        gameScene.setOnKeyReleased(e -> keyReleased(e.getCode()));
        gameScene.setOnMouseClicked(e -> setMouseClicked(e.getX(), e.getY()));
        gameScene.setOnMouseMoved(e -> setMouseLocation(e.getX(), e.getY()));
    }


    public void keyPressed(KeyCode e) {
        keyPressed.add(e);
        keyDown.add(e);
    }

    public void keyReleased(KeyCode e) {
        keyDown.remove(e);
    }

    public void setMouseClicked(double x, double y) {
        mouseClicked = true;
        setMouseLocation(x,y);
    }
    public void setMouseLocation(double x, double y) {
        mouseX = x;
        mouseY = y;
    }

    public boolean isDown(KeyCode e){
        return(keyDown.contains(e));
    }

    public boolean isPressed(KeyCode e){
        return(keyPressed.contains(e));
    }

    public boolean isMouseClicked() {
        return(mouseClicked);
    }

    public double[] getMouseLocation () {
        return(new double[] {mouseX,mouseY});
    }

    public void update() {
        mouseClicked = false;
        keyPressed.clear();
    }


}
