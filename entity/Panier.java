package entity;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Panier {

    private double position_x_panier;
    private static int position_y_panier = 380;
    private int width_panier;
    private int height_panier;
    private boolean isCatchedBall = false;
    private Image image_panier;

    public Panier(ImageIcon image, double position_x_panier, int width_panier, int height_panier) {
        this.position_x_panier = position_x_panier;
        this.width_panier = width_panier;
        this.height_panier = height_panier;
        this.image_panier = image.getImage();
    }

    public double getPositionXPanier() {
        return position_x_panier;
    }

    public void setPositionXPanier(double position_x_panier) {
        this.position_x_panier = position_x_panier;
    }

    public int getPositionYPanier() {
        return position_y_panier;
    }

    public int getWidthPanier() {
        return width_panier;
    }

    public void setWidthPanier(int width_panier) {
        this.width_panier = width_panier;
    }

    public int getHeightPanier() {
        return height_panier;
    }

    public void setHeightPanier(int height_panier) {
        this.height_panier = height_panier;
    }

    public boolean getIsCatchedBall() {
        return isCatchedBall;
    }

    public void setIsCatchedBall(boolean isCatchedBall) {
        this.isCatchedBall = isCatchedBall;
    }

    public Image getImagePanier() {
        return image_panier;
    }

    public void setImagePanier(Image image_panier) {
        this.image_panier = image_panier;
    }

    public boolean catchBall(Balle balle) {
        if ((balle.getPositionXBalle() < (this.getPositionXPanier() + this.getWidthPanier())) &&
                (balle.getPositionXBalle() > (this.getPositionXPanier() - this.getWidthPanier())) &&
                (balle.getPositionYBalle() == (this.getPositionYPanier()))) {
            return true;
        }
        return false;
    }
}
