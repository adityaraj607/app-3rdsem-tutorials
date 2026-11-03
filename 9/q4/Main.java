import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    String sql = "INSERT INTO Book VALUES(?,?,?,?,TRUE)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, id);
                        ps.setString(2, title);
                        ps.setString(3, author);
                        ps.setDouble(4, price);
                        ps.executeUpdate();
                        System.out.println("Book inserted successfully.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    try (PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM Book WHERE BookID=?")) {
                        ps.setInt(1, id);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                System.out.println("Title: " + rs.getString("Title"));
                                System.out.println("Author: " + rs.getString("Author"));
                                System.out.println("Price: " + rs.getDouble("Price"));
                                System.out.println("Available: " + rs.getBoolean("Availability"));
                            } else {
                                System.out.println("Book not found.");
                            }
                        }
                    }
                } else if (choice == 3) {
                    try (PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM Book WHERE Availability=TRUE");
                         ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            System.out.println(rs.getInt("BookID") + " | " +
                                    rs.getString("Title") + " | " +
                                    rs.getString("Author") + " | Rs. " +
                                    rs.getDouble("Price"));
                        }
                    }
                } else if (choice == 4) {
                    System.out.print("Enter Book ID to issue: ");
                    int id = sc.nextInt();
                    try (PreparedStatement ps = con.prepareStatement(
                            "UPDATE Book SET Availability=FALSE WHERE BookID=? AND Availability=TRUE")) {
                        ps.setInt(1, id);
                        int rows = ps.executeUpdate();
                        System.out.println(rows > 0
                                ? "Book issued successfully."
                                : "Book not found or already issued.");
                    }
                } else if (choice == 5) {
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
