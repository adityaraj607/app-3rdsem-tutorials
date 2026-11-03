import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class EmployeeModel {
    String username = "admin";
    String password = "admin123";
    ArrayList<String[]> employees = new ArrayList<>();

    boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    boolean changePassword(String oldPass, String newPass) {
        if (!password.equals(oldPass)) return false;
        password = newPass;
        return true;
    }

    void addEmployee(String id, String name, String dept) {
        employees.add(new String[]{id, name, dept});
    }
}

class EmployeeView {
    JFrame frame = new JFrame("Employee Management Portal");

    EmployeeView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
    }

    void showLogin(EmployeeController controller) {
        JFrame login = new JFrame("Login");
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton button = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(password);
        panel.add(new JLabel());
        panel.add(button);

        button.addActionListener(e -> {
            if (controller.login(username.getText(),
                    new String(password.getPassword()))) {
                login.dispose();
                showMain(controller);
            } else {
                JOptionPane.showMessageDialog(login,
                        "Invalid username or password.");
            }
        });

        login.add(panel);
        login.setSize(350, 180);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }

    void showMain(EmployeeController controller) {
        JMenuBar bar = new JMenuBar();
        JMenu employee = new JMenu("Employee");
        JMenu tools = new JMenu("Tools");
        JMenu exit = new JMenu("Exit");

        JMenuItem add = new JMenuItem("Add Employee");
        JMenuItem view = new JMenuItem("View Employee");
        JMenuItem change = new JMenuItem("Change Password");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem quit = new JMenuItem("Exit Application");

        employee.add(add);
        employee.add(view);
        tools.add(change);
        exit.add(logout);
        exit.add(quit);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);

        frame.setJMenuBar(bar);
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Welcome to Employee Management Portal",
                SwingConstants.CENTER), BorderLayout.CENTER);

        add.addActionListener(e -> addEmployee(controller));
        view.addActionListener(e -> viewEmployees(controller));
        change.addActionListener(e -> changePassword(controller));
        logout.addActionListener(e -> {
            frame.dispose();
            showLogin(controller);
        });

        quit.addActionListener(e -> System.exit(0));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void addEmployee(EmployeeController controller) {
        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dept = new JTextField();

        Object[] fields = {
            "Employee ID:", id,
            "Employee Name:", name,
            "Department:", dept
        };

        int result = JOptionPane.showConfirmDialog(frame, fields,
                "Add Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (id.getText().trim().isEmpty() ||
                    name.getText().trim().isEmpty() ||
                    dept.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "All fields are required.");
                return;
            }

            controller.addEmployee(id.getText(), name.getText(),
                    dept.getText());
            JOptionPane.showMessageDialog(frame,
                    "Employee added successfully.");
        }
    }

    void viewEmployees(EmployeeController controller) {
        StringBuilder text = new StringBuilder();
        for (String[] emp : controller.getEmployees()) {
            text.append("ID: ").append(emp[0])
                    .append(", Name: ").append(emp[1])
                    .append(", Department: ").append(emp[2])
                    .append("\n");
        }
        JOptionPane.showMessageDialog(frame,
                text.length() == 0 ? "No employees found." : text.toString());
    }

    void changePassword(EmployeeController controller) {
        JPasswordField oldPass = new JPasswordField();
        JPasswordField newPass = new JPasswordField();
        JPasswordField confirm = new JPasswordField();

        Object[] fields = {
            "Old Password:", oldPass,
            "New Password:", newPass,
            "Confirm Password:", confirm
        };

        int result = JOptionPane.showConfirmDialog(frame, fields,
                "Change Password", JOptionPane.OK_CANCEL_OPTION);

        if (result != JOptionPane.OK_OPTION) return;

        String old = new String(oldPass.getPassword());
        String next = new String(newPass.getPassword());
        String check = new String(confirm.getPassword());

        if (next.isEmpty() || !next.equals(check)) {
            JOptionPane.showMessageDialog(frame,
                    "New and confirm passwords must match and cannot be empty.");
        } else if (controller.changePassword(old, next)) {
            JOptionPane.showMessageDialog(frame,
                    "Password changed successfully.");
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Incorrect old password.");
        }
    }
}

class EmployeeController {
    EmployeeModel model = new EmployeeModel();
    EmployeeView view = new EmployeeView();

    void start() {
        view.showLogin(this);
    }

    boolean login(String u, String p) {
        return model.login(u, p);
    }

    void addEmployee(String id, String name, String dept) {
        model.addEmployee(id, name, dept);
    }

    ArrayList<String[]> getEmployees() {
        return model.employees;
    }

    boolean changePassword(String oldPass, String newPass) {
        return model.changePassword(oldPass, newPass);
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeController().start());
    }
}
