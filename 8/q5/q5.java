import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class q5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Course Management");
        frame.setSize(600, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 100, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(130, 30, 180, 30);

        String[] courses = {"COA", "DSA", "APP", "NMA", "OS"};
        JList<String> courseList = new JList<>(courses);
        JScrollPane courseScroll = new JScrollPane(courseList);
        courseScroll.setBounds(30, 80, 180, 100);

        JButton add = new JButton("Add");
        add.setBounds(230, 100, 80, 30);
        JButton remove = new JButton("Remove");
        remove.setBounds(230, 140, 80, 30);

        String[] columns = {"Student Name", "Selected Course", "Enrollment Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBounds(30, 210, 520, 150);

        add.addActionListener(e -> {
            String name = nameField.getText();
            String course = courseList.getSelectedValue();
            if (!name.isEmpty() && course != null) {
                model.addRow(new Object[]{name, course, "Enrolled"});
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Enter student name and select a course");
            }
        });

        remove.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Select a registration to remove");
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(courseScroll);
        frame.add(add);
        frame.add(remove);
        frame.add(tableScroll);

        frame.setVisible(true);
    }
}
