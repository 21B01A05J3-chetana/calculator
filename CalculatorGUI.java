//to run we need to apply the following commands
//javac CalculatorGUI.java
//java -cp . CalculatorGUI    or     java CalculatorGUI






import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI implements ActionListener {

    // Creating frame
    JFrame frame;
    JTextField textField;
    
    // Store operator and operands
    String operator;
    double num1, num2, result;

    // Creating constructor to initialize the frame and components
    public CalculatorGUI() {
        // Frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);
        
        // Textfield
        textField = new JTextField();
        textField.setBounds(30, 40, 320, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setEditable(false);
        frame.add(textField);
        
        // Creating number buttons and operator buttons
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
            numberButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton decButton = new JButton(".");
        JButton equButton = new JButton("=");
        JButton clrButton = new JButton("C");
        JButton delButton = new JButton("Del");

        // Setting fonts for buttons
        addButton.setFont(new Font("Arial", Font.PLAIN, 30));
        subButton.setFont(new Font("Arial", Font.PLAIN, 30));
        mulButton.setFont(new Font("Arial", Font.PLAIN, 30));
        divButton.setFont(new Font("Arial", Font.PLAIN, 30));
        decButton.setFont(new Font("Arial", Font.PLAIN, 30));
        equButton.setFont(new Font("Arial", Font.PLAIN, 30));
        clrButton.setFont(new Font("Arial", Font.PLAIN, 30));
        delButton.setFont(new Font("Arial", Font.PLAIN, 30));

        // Adding ActionListener for operation buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        decButton.addActionListener(this);
        equButton.addActionListener(this);
        clrButton.addActionListener(this);
        delButton.addActionListener(this);

        // Panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setBounds(30, 100, 320, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        
        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(clrButton);
        panel.add(delButton);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    // Overriding actionPerformed method to add functionality to buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            // If a number or decimal point is pressed, append it to the text field
            textField.setText(textField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            // Clear the text field
            textField.setText("");
        } else if (command.charAt(0) == 'D') {
            // Delete the last character in the text field
            String text = textField.getText();
            textField.setText(text.substring(0, text.length() - 1));
        } else if (command.charAt(0) == '=') {
            // Perform the calculation
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else {
            // Store the first operand and operator
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
    }

    // Main method
    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
