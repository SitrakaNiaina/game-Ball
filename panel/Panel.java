package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JFrame {
    JPanel writeHead = new JPanel();
    JPanel writeBody = new JPanel();
    JButton one = new JButton("1");

    JLabel response = new JLabel("100000");

    public Panel() {
        setTitle("Game Play");
        setSize(1000, 600);
        setResizable(false);
        setLocation(600, 50);
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

        writeHead.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        writeHead.setPreferredSize(new Dimension(380, 50));
        
        writeHead.add(response);
        add(writeHead);

        writeBody.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        writeBody.setPreferredSize(new Dimension(380, 400));

        add(writeBody);
    }
}