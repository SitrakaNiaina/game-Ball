package panel;

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
    private Timer timer;
    private int score = 0;
    private boolean gameOver = false;
    private GameCanvas gameCanvas;

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
        
        panier = new Panier(new ImageIcon("C:/Users/Sitraka/Pictures/PNG/panier.png"),200, 60, 50);
        balle = new Balle(200, 0);

        gameCanvas = new GameCanvas(panier, balle);
        add(gameCanvas);
        
        addKeyListener(new ActionGame(panier, balle, this));
        setVisible(true);
    }

    public void startGame() {
        resetBall();
        timer = new Timer(30, (ActionListener) this);
        timer.start();
    }

    private void resetBall() {
        Random random = new Random();
        int startX = random.nextInt(400 - balle.getDiameter());
        balle.resetPositionBall(startX, 0);
    }
}