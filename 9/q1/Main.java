import javax.swing.*;
import java.awt.*;

class StudentModel {
    String name, grade;
    double total, average;

    void calculate(String name, double m1, double m2, double m3) {
        this.name = name;
        total = m1 + m2 + m3;
        average = total / 3;

        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }
}

class StudentView extends JFrame {
    JTextField name = new JTextField();
    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();
    JTextField m3 = new JTextField();
    JButton calculate = new JButton("Calculate Result");
    JLabel result = new JLabel("Enter details and calculate result");

    StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Student Name:"));
        add(name);
        add(new JLabel("Subject 1 Marks:"));
        add(m1);
        add(new JLabel("Subject 2 Marks:"));
        add(m2);
        add(new JLabel("Subject 3 Marks:"));
        add(m3);
        add(calculate);
        add(result);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class StudentController {
    StudentModel model = new StudentModel();
    StudentView view = new StudentView();

    StudentController() {
        view.calculate.addActionListener(e -> {
            try {
                double a = Double.parseDouble(view.m1.getText());
                double b = Double.parseDouble(view.m2.getText());
                double c = Double.parseDouble(view.m3.getText());

                if (view.name.getText().trim().isEmpty() ||
                        a < 0 || a > 100 || b < 0 || b > 100 ||
                        c < 0 || c > 100) {
                    throw new IllegalArgumentException();
                }

                model.calculate(view.name.getText(), a, b, c);
                view.result.setText(String.format(
                        "Total: %.1f | Average: %.2f | Grade: %s",
                        model.total, model.average, model.grade));
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view,
                        "Enter a name and valid marks between 0 and 100.");
            }
        });
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentController());
    }
}
