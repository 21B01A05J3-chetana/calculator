Let's go through the code step by step to understand its components and how everything works:

1. Imports
java
Copy code
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
javax.swing.*: This imports the Swing library, which is used to create the graphical user interface (GUI) elements like JFrame, JButton, and JTextField.
java.awt.*: This imports the Abstract Window Toolkit (AWT) classes like Font, GridLayout, and Container that handle layout and design elements.
java.awt.event.*: This imports the event handling classes, specifically ActionEvent and ActionListener, which allow you to define actions that occur when buttons are clicked.
2. Class Declaration
java
Copy code
public class CalculatorGUI implements ActionListener {
CalculatorGUI: This is the class name, which defines a calculator GUI.
implements ActionListener: This means the class will handle button click events. The ActionListener interface requires the actionPerformed method to be implemented, which will define what happens when an action occurs (e.g., when a button is pressed).
3. Instance Variables
java
Copy code
    JFrame frame;
    JTextField textField;
    String operator;
    double num1, num2, result;
JFrame frame: This creates a window (frame) that holds the calculator.
JTextField textField: This creates a text field where user input (numbers and results) is displayed.
String operator: Stores the operator for the calculation (e.g., +, -, *, /).
double num1, num2, result: These variables store the operands (num1 and num2) and the result of the calculation.
4. Constructor
java
Copy code
public CalculatorGUI() {
This is the constructor, called when you create an instance of the class. It initializes the GUI components.

4.1 Creating the Frame
java
Copy code
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setLayout(null);
new JFrame("Calculator"): Creates a new window with the title "Calculator".
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE): Ensures that when the user clicks the close button, the application will exit.
setSize(400, 600): Sets the dimensions of the window to 400x600 pixels.
setLayout(null): Uses a null layout, allowing manual placement of components using coordinates.
4.2 Creating the Text Field
java
Copy code
    textField = new JTextField();
    textField.setBounds(30, 40, 320, 50);
    textField.setFont(new Font("Arial", Font.PLAIN, 30));
    textField.setEditable(false);
    frame.add(textField);
new JTextField(): Creates a text field where numbers and results are displayed.
setBounds(30, 40, 320, 50): Sets the position (x=30, y=40) and size (width=320, height=50) of the text field.
setFont(new Font("Arial", Font.PLAIN, 30)): Sets the font type to Arial, with a plain style and size 30 for the text inside the text field.
setEditable(false): Makes the text field non-editable (user cannot type into it directly).
frame.add(textField): Adds the text field to the frame.
4.3 Creating Number and Operator Buttons
java
Copy code
    JButton[] numberButtons = new JButton[10];
    for (int i = 0; i < 10; i++) {
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
        numberButtons[i].addActionListener(this);
    }
new JButton[10]: Creates an array of buttons for numbers 0 to 9.
for (int i = 0; i < 10; i++): A loop that iterates through 0 to 9 to create buttons.
new JButton(String.valueOf(i)): Converts the integer i to a string and creates a button with that number (e.g., "0", "1", "2").
setFont(new Font("Arial", Font.PLAIN, 30)): Sets the font for each button.
addActionListener(this): Registers the current class as the event handler for each button click.
4.4 Operator and Other Buttons
java
Copy code
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("*");
    JButton divButton = new JButton("/");
    JButton decButton = new JButton(".");
    JButton equButton = new JButton("=");
    JButton clrButton = new JButton("C");
    JButton delButton = new JButton("Del");
Creates buttons for operations (+, -, *, /), decimal (.), equals (=), clear (C), and delete (Del).
4.5 Setting Fonts and Adding Listeners
java
Copy code
    addButton.setFont(new Font("Arial", Font.PLAIN, 30));
    subButton.setFont(new Font("Arial", Font.PLAIN, 30));
    // (Same for other buttons)
    addButton.addActionListener(this);
    subButton.addActionListener(this);
    // (Same for other buttons)
Sets the font for each operator button and registers event listeners for button clicks.
4.6 Creating and Adding Buttons to the Panel
java
Copy code
    JPanel panel = new JPanel();
    panel.setBounds(30, 100, 320, 400);
    panel.setLayout(new GridLayout(5, 4, 10, 10));
    
    panel.add(numberButtons[1]);
    // (Add other buttons here)
    frame.add(panel);
new JPanel(): Creates a panel to hold the buttons.
setBounds(30, 100, 320, 400): Sets the position and size of the panel.
new GridLayout(5, 4, 10, 10): Sets a grid layout with 5 rows and 4 columns, and 10px padding between components.
panel.add(numberButtons[1]): Adds buttons to the panel.
frame.add(panel): Adds the panel to the frame.
4.7 Making the Frame Visible
java
Copy code
    frame.setVisible(true);
Makes the window (frame) visible on the screen.
5. Handling Button Clicks
java
Copy code
@Override
public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
actionPerformed(ActionEvent e): This method is called whenever a button is clicked. It determines the action based on the button pressed.
5.1 Handling Numbers and Decimal Point
java
Copy code
    if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
        textField.setText(textField.getText() + command);
If a number or decimal (.) is clicked, it appends the value to the current text in the text field.
5.2 Handling Clear (C) Button
java
Copy code
    } else if (command.charAt(0) == 'C') {
        textField.setText("");
Clears the text field.
5.3 Handling Delete (Del) Button
java
Copy code
    } else if (command.charAt(0) == 'D') {
        String text = textField.getText();
        textField.setText(text.substring(0, text.length() - 1));
Deletes the last character from the text field.
5.4 Handling Equals (=) Button
java
Copy code
    } else if (command.charAt(0) == '=') {
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
Performs the calculation when the = button is clicked. It reads the second operand (num2) and performs the operation stored in operator.
5.5 Handling Operators
java
Copy code
    } else {
        num1 = Double.parseDouble(textField.getText());
        operator = command;
        textField.setText("");
    }
Stores the first operand (num1) and the operator, then clears the text field.
6. Main Method
java
Copy code
public static void main(String[] args) {
    new CalculatorGUI();
}
This is the entry point of the program. It creates an instance of the CalculatorGUI class, which in turn creates and displays the calculator window.
This code creates a simple graphical calculator with functionality for basic arithmetic operations. It responds to button presses, displays the results, and handles errors like clearing or deleting input.
