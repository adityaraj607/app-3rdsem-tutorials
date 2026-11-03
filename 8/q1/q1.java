class HospitalTask extends Thread {
    public HospitalTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName() + " - Priority: " + getPriority());
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is executing task " + i);
        }
    }
}

public class q1 {
    public static void main(String[] args) {
        HospitalTask emergencyAlert = new HospitalTask("EmergencyAlert");
        HospitalTask vitalMonitor = new HospitalTask("VitalMonitor");
        HospitalTask reportGenerator = new HospitalTask("ReportGenerator");

        emergencyAlert.setPriority(3);
        vitalMonitor.setPriority(2);
        reportGenerator.setPriority(1);

        System.out.println("Hospital Monitoring Threads:");
        System.out.println(emergencyAlert.getName() + " - Priority: " + emergencyAlert.getPriority());
        System.out.println(vitalMonitor.getName() + " - Priority: " + vitalMonitor.getPriority());
        System.out.println(reportGenerator.getName() + " - Priority: " + reportGenerator.getPriority());

        emergencyAlert.start();
        vitalMonitor.start();
        reportGenerator.start();
    }
}
