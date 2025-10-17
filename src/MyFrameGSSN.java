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
    private int maxTries;

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

        //attempts
        JPanel attemptsPanel = new JPanel();
        attemptsPanel.add(attField = new JTextField(2));
        attemptsPanel.add(attemptsMsgLabel = new JLabel("Choose your attempts"));
        attemptsPanel.add(setAttemptsButton = new JButton("Go!"));


        //guess
        JPanel guessPanel = new JPanel();
        guessPanel.add(inputField = new JTextField(5));
        guessPanel.add(msgLabel = new JLabel("Guess the number from 1 to 100!"));
        guessPanel.add(guessButton = new JButton("Try!"));

       //msgLabel = new JLabel("Guess the number from 1 to 100!");

        add(attemptsPanel);
        //add(msgLabel);
        add(guessPanel);

        setAttemptsButton.addActionListener(e ->{

                String text = attField.getText();

                try{
                    maxTries = Integer.parseInt(text);
                    attempts = 0;
                    //msgLabel.setText("You have " + maxTries + " attempts!");
                    //guessButton.setEnabled(true);
                    setAttemptsButton.setEnabled(false);
                }catch (NumberFormatException ex){
                    msgLabel.setText("Please enter an integer!");
                }


        });


        guessButton.addActionListener(e->{

                String txt = inputField.getText();

                try{
                    int guess = Integer.parseInt(txt);
                    attempts++;
                    int counter = maxTries;

                    if(guess == secretNum){
                        msgLabel.setText("Congrats! You guessed the number!");
                        guessButton.setEnabled(false);
                    }else if(guess < secretNum){
                        counter--;
                        msgLabel.setText("Try again! :( The number is bigger. You have " + counter + " attempts left");
                    }else{
                        counter--;
                        msgLabel.setText("Try again! :( The number is smaller, You have " + counter + " attempts left");
                    }

                    if(attempts >= maxTries && guess != secretNum){
                        msgLabel.setText("You`re out of tries. The number was: " + secretNum);
                        guessButton.setEnabled(false);
                    }

                    inputField.setText("");
                }catch(NumberFormatException exc){
                    msgLabel.setText("Please enter an integer!");
                }

        });
    }

    public static void main(String[] args){
        new MyFrameGSSN();
    }
}
