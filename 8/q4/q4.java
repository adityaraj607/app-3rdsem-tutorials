import javax.swing.*;

public class q4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Login");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 30);
        JTextField userField = new JTextField();
        userField.setBounds(130, 30, 200, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 30);
        JPasswordField passField = new JPasswordField();
        passField.setBounds(130, 70, 200, 30);

        JCheckBox remember = new JCheckBox("Remember Me");
        remember.setBounds(30, 120, 130, 30);

        JCheckBox notifications = new JCheckBox("Receive Notifications");
        notifications.setBounds(160, 120, 170, 30);

        JButton login = new JButton("Login");
        login.setBounds(140, 180, 100, 35);

        login.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(frame,
                        "Login Successful!\nWelcome " + username);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Invalid Username or Password");
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(remember);
        frame.add(notifications);
        frame.add(login);

        frame.setVisible(true);
    }
}
