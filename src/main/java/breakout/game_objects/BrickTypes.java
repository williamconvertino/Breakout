package breakout.game_objects;

public enum BrickTypes {

    //Enums
    BASIC_BLUE("Blue_Tile.png");


    //Variables
    String texturePath;


    //Methods
    private BrickTypes(String texturePath) {
        this.texturePath = texturePath;
    }

    public static String getPath(BrickTypes type) {
        return type.texturePath;
    }

}
