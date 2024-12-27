package entity;

public class Paysage {

    private String name;
    private static int DIMENSION_WIDTH = 100;
    private static int DIMENSION_HEIGHT = 100;
    private static int POSITION_X = 0;
    private static int POSITION_Y = 0;

    public Paysage(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDimesionWidth() {
        return Paysage.DIMENSION_WIDTH;
    }

    public int getDimesionHeight() {
        return Paysage.DIMENSION_HEIGHT;
    }

    public int getPositionX() {
        return Paysage.POSITION_X;
    }

    public int getPositionY() {
        return Paysage.POSITION_Y;
    }
}
