package panel;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import entity.Balle;
import entity.Panier;

public class GameCanvas extends JPanel {

    private Panier panier;
    private Balle balle;

    public GameCanvas(Panier panier, Balle balle) {
        this.panier = panier;
        this.balle = balle;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(((int)balle.getPositionXBalle()), ((int)balle.getPositionYBalle()), balle.getDiameter(), balle.getDiameter());

        g.setColor(Color.BLUE);
        g.drawImage(panier.getImagePanier(),((int)panier.getPositionXPanier()), ((int)panier.getPositionYPanier()), panier.getWidthPanier(), panier.getHeightPanier(), null);
    }
}
