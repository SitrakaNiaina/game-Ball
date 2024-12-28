package panel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import entity.Balle;
import entity.Panier;

public class Panel extends JFrame {

    private Panier panier;
    private Balle balle;
    private GameCanvas gameCanvas;
    private Timer timer;
    private int score = 0;
    private boolean gameOver = false;

    private void initLayout() {
        setTitle("Game Play");
        setSize(400, 600);
        setResizable(false);
        setLocation(800, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    public Panel() {
        initLayout();

        /**
         * Create a new basket
         */
        panier = new Panier(
                new ImageIcon("C:/Users/Sitraka/Pictures/PNG/panier.png"),
                160,
                60,
                50);

        /**
         * Create a new Ball
         */
        balle = new Balle(
                new ImageIcon("C:/Users/Sitraka/Pictures/PNG/balle.png"),
                200,
                0);

        /**
         * Draw the plateforme Game Center
         */
        gameCanvas = new GameCanvas(panier, balle, this);
        add(gameCanvas);

        addKeyListener(new ActionGame(panier, balle, this));
        this.startGame();
        setVisible(true);
    }

    private void startGame() {
        resetBall();
        timer = new Timer(balle.getBalleSpeed(), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                balle.moveDown();
                if (panier.catchBall(balle)) {
                    score++;
                    resetBall();
                }

                if (balle.isOutOfBounds(panier)) {
                    gameOver = true;
                    timer.stop();
                }
                gameCanvas.repaint();
            }
        });
        timer.start();
    }

    private void resetBall() {
        Random random = new Random();
        int startX = random.nextInt(400 - balle.getDiameter());
        balle.resetPositionBall(startX, 0);
    }

    public Image getBackgroundImage() {
        return new ImageIcon("C:/Users/Sitraka/Pictures/PNG/plateforme.jpg").getImage();
    }
}