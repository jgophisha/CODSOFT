package task4;

import java.awt.*;
import javax.swing.*;

public class Score extends JFrame {
    public Score(int score, int correctAnswers, int incorans) {
        setBounds(50, 0, 500, 500);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel head = new JLabel("Thank you for playing");
        head.setBounds(50, 50, 1000, 50);
        head.setFont(new Font("Tahoma", Font.PLAIN, 26));
        head.setForeground(Color.blue);
        add(head);

        JLabel lblscore = new JLabel("Your Score is " + score);
        lblscore.setBounds(50, 150, 1000, 50);
        lblscore.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblscore.setForeground(Color.orange);
        add(lblscore);

        JLabel lblcorrect = new JLabel("Correct Answers : " + correctAnswers);
        lblcorrect.setBounds(50, 250, 1000, 50);
        lblcorrect.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblcorrect.setForeground(Color.green);
        add(lblcorrect);

        JLabel lblincorrect = new JLabel("Incorrect Answers : " + incorans);
        lblincorrect.setBounds(50, 350, 1000, 50);
        lblincorrect.setFont(new Font("Dialog", Font.PLAIN, 24));
        lblincorrect.setForeground(Color.red);
        add(lblincorrect);

        setVisible(true);
    }
}
