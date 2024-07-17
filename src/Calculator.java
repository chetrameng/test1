import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        clearButton = new JButton("Clear");

        add(new JLabel("First Number:"));
        add(firstNumberField);
        add(new JLabel("Second Number:"));
        add(secondNumberField);
        add(new JLabel("Result:"));
        add(resultField);

        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(modulusButton);
        add(clearButton);

        addButton.addActionListener(e -> calculate('+'));
        subtractButton.addActionListener(e -> calculate('-'));
        multiplyButton.addActionListener(e -> calculate('*'));
        divideButton.addActionListener(e -> calculate('/'));
        modulusButton.addActionListener(e -> calculate('%'));
        clearButton.addActionListener(e -> clearFields());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
                case '%': result = num1 % num2; break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    private void clearFields() {
        firstNumberField.setText("");
        secondNumberField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}