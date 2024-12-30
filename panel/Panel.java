package panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import entity.Balle;
import entity.Panier;
import entity.SoundPlayer;

public class Panel extends JFrame {

    // private JLayeredPane layeredPane = new JLayeredPane();
    private JPanel panelGameOver = new JPanel();
    private int score = 0;
    private JLabel labelScore = new JLabel("Score : " + score);

    private Panier panier;
    private Balle balle;
    private GameCanvas gameCanvas;
    private Timer timer;
    // private boolean gameOver = false;

    private void initLayout() {
        this.setTitle("Game Play");
        this.setSize(400, 650);
        this.setResizable(true);
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
        
        // layeredPane.setBounds(0,  0,  400, 600);

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
        panelGameOver.setLayout(new GridLayout(1, 2));
        panelGameOver.add(startButton);
        panelGameOver.add(labelScore);

        add(panelGameOver);
        // layeredPane.add(panelGameOver, Integer.valueOf(0));

        /**
         * Draw the plateforme Game Center
         */
        gameCanvas = new GameCanvas(panier, balle, this);
        gameCanvas.setPreferredSize(new Dimension(400, 600));
        add(gameCanvas);
        // layeredPane.add(gameCanvas, Integer.valueOf(1));
        // add(layeredPane);

        addKeyListener(new ActionGame(panier, balle, this));
        setFocusable(true);
        setVisible(true);
    }

    public void startGame() {
        timer = new Timer(balle.getBalleSpeed(), new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                balle.moveDown();
                if (panier.catchBall(balle)) {
                    score += 1;
                    labelScore.setText("Score : " + score);
                    SoundPlayer.playSoundMp3("./sound/pluck-off.mp3");
                    resetBall();
                }

                if (balle.isOutOfBounds(panier))
                    timer.stop();

                this.updateLevel();
                gameCanvas.repaint();
            }

            private void updateLevel(){
                if(score > (balle.getBalleSpeed() * 10)) {
                    balle.setBalleSpeed(balle.getBalleSpeed() + 1);
                }
            }
        });
        timer.start();
    }

    private void resetBall() {
        Random random = new Random();
        int startX = random.nextInt(gameCanvas.getWidth() - balle.getDiameter());
        balle.resetPositionBall(startX, 0);
    }

    public Image getBackgroundImage() {
        return new ImageIcon("./img/plateforme.jpg").getImage();
    }
}