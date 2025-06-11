import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DiceSimulatorGUI extends JFrame {
    private JTextField inputField;
    private JButton rollButton;
    private JTextArea resultArea;

    public DiceSimulatorGUI() {
        setTitle("Dice Simulator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter number of dice:"));

        inputField = new JTextField(10);
        add(inputField);

        rollButton = new JButton("Roll Dice");
        add(rollButton);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // Button action
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        setVisible(true);
    }

    private void rollDice() {
        try {
            int numberOfDice = Integer.parseInt(inputField.getText());
            if (numberOfDice <= 0) {
                resultArea.setText("Please enter a number greater than 0.");
                return;
            }

            Random random = new Random();
            StringBuilder results = new StringBuilder("You rolled:\n");
            int total = 0;

            for (int i = 1; i <= numberOfDice; i++) {
                int roll = random.nextInt(6) + 1;
                results.append("Die ").append(i).append(": ").append(roll).append("\n");
                total += roll;
            }

            results.append("Total: ").append(total);
            resultArea.setText(results.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input! Please enter a whole number.");
        }
    }

    public static void main(String[] args) {
        new DiceSimulatorGUI();
    }
}

