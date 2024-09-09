package task4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userans[][] = new String[10][1];
    JLabel qno, ques;
    JRadioButton opt1, opt_2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit;
    
    public static int timer = 15;
    public static int ans = 0;
    public static int count = 0;
    public static int score = 0;
    public static int correctanswer = 0;
    public static int incorans = 0;

    public Quiz() {
        setBounds(50, 0, 1200, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        qno = new JLabel();
        qno.setBounds(50, 50, 50, 30);
        qno.setFont(new Font("Sans-serif", Font.PLAIN, 24));
        qno.setForeground(Color.blue);
        add(qno);
        
        ques = new JLabel("");
        ques.setBounds(100, 50, 1400, 30);
        ques.setFont(new Font("Sans-serif", Font.PLAIN, 24)); // Corrected font set to ques
        ques.setForeground(Color.blue);
        getContentPane().add(ques);

        // Initialize questions and answers
        initializeQuestionsAndAnswers();

        opt1 = new JRadioButton();
        opt1.setBounds(120, 120, 500, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        getContentPane().add(opt1);

        opt_2 = new JRadioButton();
        opt_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt_2.setBackground(Color.WHITE);
        opt_2.setBounds(120, 160, 500, 30);
        getContentPane().add(opt_2);

        opt3 = new JRadioButton();
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBackground(Color.WHITE);
        opt3.setBounds(120, 200, 500, 30);
        getContentPane().add(opt3);

        opt4 = new JRadioButton();
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBackground(Color.WHITE);
        opt4.setBounds(120, 240, 500, 30);
        getContentPane().add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt_2);
        group.add(opt3);
        group.add(opt4);

        next = new JButton("Next");
        next.setBounds(850, 200, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 240));
        next.setForeground(Color.white);
        next.addActionListener(this); // Added ActionListener for the next button
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(850, 280, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 240));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ans = 1;
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans = 1;
            if (group.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = group.getSelection().getActionCommand();
            }

            for (int i = 0; i < userans.length; i++) {
                if (userans[i][0].equals(answers[i][1])) {
                    score += 10;
                    correctanswer++;
                } else {
                    incorans++;
                }
            }
            setVisible(false);
            new Score(score, correctanswer, incorans);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left :" + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 800, 150);
        } else {
            g.drawString("Timed out", 800, 150);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans == 1) {
            ans = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }

                for (int i = 0; i < userans.length; i++) {
                    if (userans[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(score, correctanswer, incorans);
            } else {
                if (group.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ".  ");
        ques.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt_2.setText(questions[count][2]);
        opt_2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    private void initializeQuestionsAndAnswers() {
    	// Question 1
    			questions[0][0] = "What is the capital of India?";
    			questions[0][1] = "India";
    			questions[0][2] = "Mumbai";
    			questions[0][3] = "Delhi"; // Correct Answer
    			questions[0][4] = "Kolkata";

    			// Question 2
    			questions[1][0] = "What is the largest planet in our solar system?";
    			questions[1][1] = "Mars";
    			questions[1][2] = "Earth";
    			questions[1][3] = "Jupiter"; // Correct Answer
    			questions[1][4] = "Saturn";

    			// Question 3
    			questions[2][0] = "Which element has the chemical symbol 'O'?";
    			questions[2][1] = "Oxygen"; // Correct Answer
    			questions[2][2] = "Osmium";
    			questions[2][3] = "Gold";
    			questions[2][4] = "Carbon";

    			// Question 4
    			questions[3][0] = "Who wrote 'Romeo and Juliet'?";
    			questions[3][1] = "Charles Dickens";
    			questions[3][2] = "William Shakespeare"; // Correct Answer
    			questions[3][3] = "Mark Twain";
    			questions[3][4] = "J.K. Rowling";

    			// Question 5
    			questions[4][0] = "Which is the longest river in the world?";
    			questions[4][1] = "Amazon";
    			questions[4][2] = "Yangtze";
    			questions[4][3] = "Nile"; // Correct Answer
    			questions[4][4] = "Mississippi";

    			// Question 6
    			questions[5][0] = "What is the square root of 64?";
    			questions[5][1] = "6";
    			questions[5][2] = "8"; // Correct Answer
    			questions[5][3] = "9";
    			questions[5][4] = "10";

    			// Question 7
    			questions[6][0] = "Which planet is known as the Red Planet?";
    			questions[6][1] = "Mars"; // Correct Answer
    			questions[6][2] = "Venus";
    			questions[6][3] = "Jupiter";
    			questions[6][4] = "Saturn";

    			// Question 8
    			questions[7][0] = "What is the currency of Japan?";
    			questions[7][1] = "Yuan";
    			questions[7][2] = "Won";
    			questions[7][3] = "Yen"; // Correct Answer
    			questions[7][4] = "Dollar";

    			// Question 9
    			questions[8][0] = "Who painted the Mona Lisa?";
    			questions[8][1] = "Vincent van Gogh";
    			questions[8][2] = "Pablo Picasso";
    			questions[8][3] = "Leonardo da Vinci"; // Correct Answer
    			questions[8][4] = "Claude Monet";

    			// Question 10
    			questions[9][0] = "Which ocean is the largest by surface area?";
    			questions[9][1] = "Atlantic Ocean";
    			questions[9][2] = "Indian Ocean";
    			questions[9][3] = "Arctic Ocean";
    			questions[9][4] = "Pacific Ocean"; 

    			answers[0][1] = "Delhi"; 

    			answers[1][1] = "Jupiter"; 
    			answers[2][1] = "Oxygen";

    			answers[3][1] = "William Shakespeare";
    			answers[4][1] = "Nile";

    			answers[5][1] = "8"; 

    			answers[6][1] = "Mars";

    			answers[7][1] = "Yen";

    			answers[8][1] = "Leonardo da Vinci"; 

    			answers[9][1] = "Pacific Ocean"; }

    public static void main(String[] args) {
        new Quiz();
    }
}
