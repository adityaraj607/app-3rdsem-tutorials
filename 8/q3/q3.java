import javax.swing.*;

public class q3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration");
        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 120, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 180, 30);

        JLabel regLabel = new JLabel("Register Number:");
        regLabel.setBounds(30, 70, 120, 30);
        JTextField regField = new JTextField();
        regField.setBounds(150, 70, 180, 30);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 120, 30);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 110, 70, 30);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 110, 80, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 150, 120, 30);
        String[] departments = {"NWC", "C.Tech", "C.Intel", "DSBS",};
        JComboBox<String> department = new JComboBox<>(departments);
        department.setBounds(150, 150, 180, 30);

        JButton submit = new JButton("Submit");
        submit.setBounds(140, 210, 100, 35);
        submit.addActionListener(e -> {
            String name = nameField.getText();
            String reg = regField.getText();
            String gender = male.isSelected() ? "Male" :
                    female.isSelected() ? "Female" : "Not Selected";
            String dept = (String) department.getSelectedItem();
            JOptionPane.showMessageDialog(frame,
                    "Student Name: " + name +
                    "\nRegister Number: " + reg +
                    "\nGender: " + gender +
                    "\nDepartment: " + dept);
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(regLabel);
        frame.add(regField);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(deptLabel);
        frame.add(department);
        frame.add(submit);

        frame.setVisible(true);
    }
}
