import doctor.Doctor;
import patient.Patient;
public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(101, "Dr. Sharma", "Cardiologist", 800);
        Doctor d2 = new Doctor(102, "Dr. Verma", "Dermatologist", 600);
        Patient p1 = new Patient(1, "Rahul", "Heart Disease", 45);
        Patient p2 = new Patient(2, "Priya", "Skin Allergy", 25);
        Patient p3 = new Patient(3, "Amit", "Heart Disease", 50);
        Doctor[] doctors = {d1, d2};
        Patient[] patients = {p1, p2, p3};
        Doctor[] assignedDoctors = {d1, d2, d1};
        double[] totalFees = new double[doctors.length];
        for (int i = 0; i < patients.length; i++) {
            System.out.println("\n--- Patient Details ---");
            patients[i].display();
            Doctor doctor = assignedDoctors[i];
            System.out.println("\n--- Treating Doctor ---");
            doctor.display();
            for (int j = 0; j < doctors.length; j++) {
                if (doctor.getDoctorId() == doctors[j].getDoctorId()) {
                    totalFees[j] += doctor.getConsultationFee();
                    break;
                }
            }
        }
        System.out.println("\n--- Total Consultation Fees ---");
        for (int i = 0; i < doctors.length; i++) {
            System.out.println(doctors[i].getName() + ": Rs. " + totalFees[i]);
        }
    }
}
