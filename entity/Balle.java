package entity;

public class Balle {
    private double position_x_balle;
    private double position_y_balle;
    private int balle_speed = 5;
    private int diameter = 10;

    public Balle(double position_x_balle, double position_y_balle) {
        this.position_x_balle = position_x_balle;
        this.position_y_balle = position_y_balle;
    }

    public double getPositionXBalle() {
        return position_x_balle;
    }

    public void setPositionXBalle(double position_x_balle) {
        this.position_x_balle = position_x_balle;
    }

    public double getPositionYBalle() {
        return position_y_balle;
    }

    public void setPositionYBalle(double position_y_balle) {
        this.position_y_balle = position_y_balle;
    }

    public int getBalleSpeed() {
        return balle_speed;
    }

    public void setBalleSpeed(int balle_speed) {
        this.balle_speed = balle_speed;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void resetPositionBall(int position_x_balle, int position_y_balle) {
        this.position_x_balle = position_x_balle;
        this.position_y_balle = position_y_balle;
    }
}
