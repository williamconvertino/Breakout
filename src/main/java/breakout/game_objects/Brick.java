package breakout.game_objects;


public class Brick extends GameObjectTangible {

    //Constructors
    public Brick(String textureName, double xpos, double ypos) {
        super(textureName, xpos, ypos);
    }

    //Constructors
    public Brick(double xpos, double ypos, BrickTypes type) {
        super(BrickTypes.getPath(type), xpos, ypos);
    }

    //Methods
    @Override
    public void interactWith(GameObjectTangible object) {

        if (object instanceof Ball) {
            setInactive(true);
        }

    }


}
