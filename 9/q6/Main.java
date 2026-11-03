import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/collegedb";
        String user = "root";
        String password = "12345678";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter Course Code: ");
            String code = sc.nextLine();

            String sql = "SELECT * FROM CourseRegistration WHERE CourseCode=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, code);
                try (ResultSet rs = ps.executeQuery()) {
                    boolean found = false;
                    while (rs.next()) {
                        found = true;
                        System.out.println("\nStudent ID: " + rs.getInt("StudentID"));
                        System.out.println("Student Name: " + rs.getString("StudentName"));
                        System.out.println("Course Code: " + rs.getString("CourseCode"));
                        System.out.println("Course Name: " + rs.getString("CourseName"));
                        System.out.println("Semester: " + rs.getInt("Semester"));
                    }
                    if (!found) {
                        System.out.println("No students registered for course " + code);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
