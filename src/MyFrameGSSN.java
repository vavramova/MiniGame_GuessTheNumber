import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameGSSN extends JFrame {
    private JTextField inputField;
    private JLabel msgLabel;
    private JButton guessButton;
    private JButton setAttemptsButton;
    private JLabel attemptsMsgLabel;
    private JTextField attField;

    private int secretNum;
    private int attempts;
    private final int maxTries = 8;

    public MyFrameGSSN(){
        setTitle("Guess the Number");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(420,420);
        setVisible(true);
        setLayout(new FlowLayout());
        //getContentPane().setBackground(Color.red);

        secretNum = (int)(Math.random() * 100) + 1;
        attempts = 0;

        attField = new JTextField(5);
        attemptsMsgLabel = new JLabel("Choose your attempts");
        setAttemptsButton = new JButton("Go!");

        add(attField);
        add(attemptsMsgLabel);
        add(setAttemptsButton);

        inputField = new JTextField(10);
        msgLabel = new JLabel("Guess the number from 1 to 100. You have 8 attempts!");
        guessButton = new JButton("Try!");

        add(inputField);
        add(msgLabel);
        add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = inputField.getText();

                try{
                    int guess = Integer.parseInt(txt);
                    attempts++;

                    if(guess == secretNum){
                        msgLabel.setText("Congrats! You guessed the number!");
                        guessButton.setEnabled(false);
                    }else if(guess < secretNum){
                        msgLabel.setText("Try again! :( The number is bigger");
                    }else{
                        msgLabel.setText("Try again! :( The number is smaller");
                    }

                    if(attempts >= maxTries && guess != secretNum){
                        msgLabel.setText("You`re out of tries. The number was: " + secretNum);
                        guessButton.setEnabled(false);
                    }

                    inputField.setText("");
                }catch(NumberFormatException exc){
                    msgLabel.setText("Please enter an integer!");
                }
            }
        });
    }

    public static void main(String[] args){
        new MyFrameGSSN();
    }
}
