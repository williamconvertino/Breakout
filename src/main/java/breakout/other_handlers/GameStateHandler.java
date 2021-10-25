package breakout.other_handlers;

public class GameStateHandler {

    //Variables
    private int lives;
    private int gameState; //-1 for a loss, 1 for a win, 0 otherwise

    //Constructors
    public GameStateHandler() {
        initializeDefaultGamestate();
    }

    //Methods
    public void initializeDefaultGamestate() {
        this.lives = 3;
        this.gameState = 0;
    }

    public void resetToDefault() {
        initializeDefaultGamestate();
    }

    public void setGameState (int state) {
        if (state > 1 || state < -1) {
            System.out.println("Error: Invalid Game State");
        } else {
            this.gameState = state;
        }
    }

    public void verifyLives() {
        if (lives <= 0 && this.gameState != 1) {
            this.gameState = -1;
        }
    }

    public void setLives (int lives) {
        this.lives = lives;
    }

    public void removeLives(int lives) {
        setLives(this.lives - lives);
    }

    public void update() {
        verifyLives();
    }

    public int getLives() {
        return lives;
    }


    public int getGameState() {
        return gameState;
    }

    public boolean gameIsLost() {return (gameState == -1);}
    public boolean gameIsWon() {return (gameState == 1);}

}
