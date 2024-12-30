package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Balle;
import entity.Panier;

public class ActionGame implements ActionListener, KeyListener{

    private Panier panier;
    private Balle balle;
    private Panel panel;

    public ActionGame(Panier panier, Balle balle, Panel panel) {
        this.panier = panier;
        this.balle = balle;
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            panel.startGame();

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (panier.getPositionXPanier() > panel.getAlignmentX() + 10)
                panier.setPositionXPanier(panier.getPositionXPanier() - (10*(balle.getBalleSpeed()/2)));
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (panier.getPositionXPanier() < (panel.getWidth() - panier.getWidthPanier() - 15))
                panier.setPositionXPanier(panier.getPositionXPanier() + (10*(balle.getBalleSpeed()/2)));
        }
        panel.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
