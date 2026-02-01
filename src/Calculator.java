//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import javax.swing.border.EmptyBorder;
import java.text.DecimalFormat;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// This Class can now understand user Action Events
public class Calculator implements ActionListener {
    // All the J Variables needed to actually develop the Calculator
    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton [] numButtons = new JButton[10];
    JButton [] funcButtons = new JButton[10];
    JButton addButton, subButton, multiButton, divButton, remainButton, equButton;
    JButton delButton, negPosButton, decButton, clrButton;

    //Font Style For Text used in Program's Frame
    Font myFont = new Font("Monospaced", Font.BOLD, 30);

    DecimalFormat df = new DecimalFormat("#.########");

    Color bgColor = Color.BLACK;
    Color buttonColor = new Color(45, 45, 45); // dark gray
    Color textColor = Color.WHITE;

    //Variables for Solving Operations
    double num1 = 0,num2 = 0, result =0;
    char operator;


    //Calculator Constructor used to actually build the Calculator
    Calculator() {

        //The Window That will show when we run the Calculator
        frame = new JFrame("DERWIN BELL'S AMAZING CALCULATOR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPanel that will hold all of our buttons
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(new EmptyBorder(12, 12, 12, 12));

        // Display
        textField = new JTextField();
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBorder(new EmptyBorder(10, 10, 10, 10));
        textField.setBackground(bgColor);
        textField.setForeground(textColor);
        textField.setCaretColor(textColor); // cursor color (good habit)
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        root.add(textField, BorderLayout.NORTH);



        //how the Buttons display to the user
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        remainButton = new JButton("%");
        delButton = new JButton("Delete");
        negPosButton = new JButton("-+");
        decButton = new JButton(".");
        clrButton = new JButton("Clear");

        //Assigning the function buttons to our Array to check through
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = multiButton;
        funcButtons[3] = divButton;
        funcButtons[4] = remainButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = negPosButton;
        funcButtons[8] = decButton;
        funcButtons[9] = clrButton;

        //Every time a Function button is pressed add ActionListener so we can take in the input
        for (int i=0; i<10; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);

            funcButtons[i].setBackground(buttonColor);
            funcButtons[i].setForeground(textColor);

            funcButtons[i].setOpaque(true);
            funcButtons[i].setBorderPainted(false);
        }

        //Every time a Number button is pressed add ActionListener so we can take in the input
        for (int j = 0; j < 10; j++){
            numButtons[j] = new JButton(String.valueOf(j));
            numButtons[j].addActionListener(this);
            numButtons[j].setFont(myFont);
            numButtons[j].setFocusable(false);

            numButtons[j].setBackground(buttonColor);
            numButtons[j].setForeground(textColor);
            numButtons[j].setOpaque(true);

            numButtons[j].setBorderPainted(false);
        }

        // Center grid (4x4) MUST be exactly 16 buttons
        panel = new JPanel(new GridLayout(4, 4, 10, 10));

        panel.setBackground(bgColor);

        // Standard calculator layout:
        // 7 8 9 /
        // 4 5 6 *
        // 1 2 3 -
        // +/- 0 . +
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(divButton);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(multiButton);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(subButton);

        panel.add(negPosButton);
        panel.add(numButtons[0]);
        panel.add(decButton);
        panel.add(addButton);

        root.add(panel, BorderLayout.CENTER);

        // Bottom row (Clear, Delete, %, =)
        JPanel bottom = new JPanel(new GridLayout(1, 4, 10, 10));
        bottom.setBackground(bgColor);

        bottom.add(clrButton);
        bottom.add(delButton);
        bottom.add(remainButton);
        bottom.add(equButton);

        styleButton(clrButton);
        styleButton(delButton);
        styleButton(equButton);
        styleButton(remainButton);
        styleButton(negPosButton);

        root.add(bottom, BorderLayout.SOUTH);


        frame.setContentPane(root);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // centers on screen
        frame.setVisible(true);
        frame.getContentPane().setBackground(bgColor);

    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();


        }


    //Method to actually React when User Input Events are Received
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++){
            if(e.getSource() == numButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == multiButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == remainButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }
        if (e.getSource() == negPosButton) {
           double temp = Double.parseDouble(textField.getText());
           temp *= -1;

            textField.setText(df.format(temp));
        }

        /*Switch Statements to preform the math on the Two numbers from user input
        After Pressing the Equal Sign
        * */

        if(e.getSource() == equButton){
            num2=Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;

            }
            textField.setText(df.format(result));
            num1=result;
        }
        // Clear Display When Pressed
        if(e.getSource() == clrButton){
            textField.setText("");
        }

        // Delete Number when Pressed
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for (int i=0; i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }



    }
    private void styleButton(JButton button) {
        button.setFont(myFont);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);            // 👈 IMPORTANT
        button.setBackground(buttonColor);
        button.setForeground(textColor);
    }
}
