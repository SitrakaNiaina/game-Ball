package panel;

import java.awt.Graphics;
import javax.swing.JPanel;

import entity.Balle;
import entity.Panier;

public class GameCanvas extends JPanel {

    private Panier panier;
    private Balle balle;
    private Panel panel;

    public GameCanvas(Panier panier, Balle balle, Panel panel) {
        this.panier = panier;
        this.balle = balle;
        this.panel = panel;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(panel.getBackgroundImage(), 0, 0, panel.getWidth(), panel.getHeight(), null);
        g.drawImage(balle.getImageBall(), ((int)balle.getPositionXBalle()), ((int)balle.getPositionYBalle()), balle.getDiameter(), balle.getDiameter(), null);
        g.drawImage(panier.getImagePanier(),((int)panier.getPositionXPanier()), ((int)panier.getPositionYPanier()), panier.getWidthPanier(), panier.getHeightPanier(), null);
    }
}
