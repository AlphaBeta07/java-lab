import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private final JTextField display = new JTextField();
    private String op = "";
    private double first = 0;
    private boolean startNew = true;

    public SimpleCalculator() {
        setTitle("Calculator");
        setSize(300, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "C"
        };

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
            // Make last row fill grid nicely
        }
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            if ("0123456789.".contains(cmd)) {
                if (startNew) {
                    display.setText(cmd.equals(".") ? "0." : cmd);
                    startNew = false;
                } else {
                    if (cmd.equals(".") && display.getText().contains(".")) return;
                    display.setText(display.getText() + cmd);
                }
            } else if (cmd.equals("C")) {
                display.setText("");
                op = "";
                first = 0;
                startNew = true;
            } else if (cmd.equals("=")) {
                double second = Double.parseDouble(display.getText());
                double result = calculate(first, second, op);
                display.setText(trim(result));
                startNew = true;
                op = "";
            } else { // operator
                first = display.getText().isEmpty() ? 0 : Double.parseDouble(display.getText());
                op = cmd;
                startNew = true;
            }
        } catch (Exception ex) {
            display.setText("Error");
            startNew = true;
        }
    }

    private double calculate(double a, double b, String o) {
        switch (o) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b == 0 ? 0 : a / b;
            default: return b;
        }
    }

    private String trim(double v) {
        if (v == (long) v) return String.format("%d", (long) v);
        return String.valueOf(v);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}
