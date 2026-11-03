import javax.swing.*;
import java.awt.*;

class ServiceModel {
    int calculate(boolean general, boolean oil, boolean brake, boolean battery) {
        int total = 0;
        if (general) total += 1000;
        if (oil) total += 800;
        if (brake) total += 1200;
        if (battery) total += 500;
        return total;
    }
}

class ServiceView extends JFrame {
    JTextField regNo = new JTextField();
    JComboBox<String> vehicle = new JComboBox<>(
            new String[]{"Two Wheeler", "Car"});
    JCheckBox general = new JCheckBox("General Service - Rs. 1000");
    JCheckBox oil = new JCheckBox("Oil Change - Rs. 800");
    JCheckBox brake = new JCheckBox("Brake Service - Rs. 1200");
    JCheckBox battery = new JCheckBox("Battery Check - Rs. 500");
    JButton calculate = new JButton("Calculate Cost");
    JLabel result = new JLabel("Total Cost: Rs. 0");

    ServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1, 5, 5));
        add(new JLabel("Registration Number:"));
        add(regNo);
        add(vehicle);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);
        add(result);
        setLayout(new GridLayout(9, 1, 5, 5));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class ServiceController {
    ServiceModel model = new ServiceModel();
    ServiceView view = new ServiceView();

    ServiceController() {
        view.calculate.addActionListener(e -> {
            if (view.regNo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(view,
                        "Enter the vehicle registration number.");
                return;
            }
            int total = model.calculate(
                    view.general.isSelected(),
                    view.oil.isSelected(),
                    view.brake.isSelected(),
                    view.battery.isSelected());
            view.result.setText("Total Cost: Rs. " + total);
        });
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ServiceController());
    }
}
