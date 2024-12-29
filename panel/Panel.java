package panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import entity.Balle;
import entity.Panier;

public class Panel extends JFrame {

    private JPanel panelGameOver = new JPanel();

    private Panier panier;
    private Balle balle;
    private GameCanvas gameCanvas;
    private Timer timer;
    // private int score = 0;
    // private boolean gameOver = false;

    private void initLayout() {
        this.setTitle("Game Play");
        this.setSize(400, 650);
        this.setResizable(false);
        this.setLocation(800, 150);
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
    }

    public Panel() {
        this.initLayout();

        /**
         * Create a new basket
         */
        panier = new Panier(
                new ImageIcon("./img/panier.png"),
                160,
                60,
                50);

        /**
         * Create a new Ball
         */
        balle = new Balle(
                new ImageIcon("./img/balle.png"),
                200,
                0);

        JButton startButton = new StartButton("Star Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                requestFocusInWindow();
            }
        });
        // panelGameOver.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelGameOver.setPreferredSize(new Dimension(400, 50));
        panelGameOver.add(startButton);
        add(panelGameOver);

        /**
         * Draw the plateforme Game Center
         */
        gameCanvas = new GameCanvas(panier, balle, this);
        gameCanvas.setPreferredSize(new Dimension(400, 600));
        add(gameCanvas);

        addKeyListener(new ActionGame(panier, balle, this));
        setFocusable(true);

        setVisible(true);
    }

    private void startGame() {
        resetBall();
        timer = new Timer(balle.getBalleSpeed(), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                balle.moveDown();
                if (panier.catchBall(balle)) {
                    // score++;
                    resetBall();
                }

                if (balle.isOutOfBounds(panier)) {
                    // gameOver = true;
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
        return new ImageIcon("./img/plateforme.jpg").getImage();
    }
}