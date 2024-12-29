package panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class StartButton extends JButton {

    public StartButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(60, 130, 200));
        g2d.fillRoundRect(0, 0, this.getWidth(),this.getHeight(), 30, 30);

        super.paintComponent(g2d);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(30, 90, 150));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(1, 1, this.getWidth() - 2, this.getHeight() - 2, 30, 30);
    }
}
