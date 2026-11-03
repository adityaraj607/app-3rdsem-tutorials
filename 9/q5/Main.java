import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3306/storedb";
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1. Insert Product");
                System.out.println("2. Search Product");
                System.out.println("3. Update Quantity");
                System.out.println("4. Display Low-Stock Products");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    String sql = "INSERT INTO Product VALUES(?,?,?,?)";
                    try (PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setDouble(3, price);
                        ps.setInt(4, qty);
                        ps.executeUpdate();
                        System.out.println("Product inserted successfully.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    try (PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM Product WHERE ProductID=?")) {
                        ps.setInt(1, id);
                        try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                System.out.println("Name: " + rs.getString("ProductName"));
                                System.out.println("Price: " + rs.getDouble("Price"));
                                System.out.println("Quantity: " + rs.getInt("Quantity"));
                            } else {
                                System.out.println("Product not found.");
                            }
                        }
                    }
                } else if (choice == 3) {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int qty = sc.nextInt();
                    try (PreparedStatement ps = con.prepareStatement(
                            "UPDATE Product SET Quantity=? WHERE ProductID=?")) {
                        ps.setInt(1, qty);
                        ps.setInt(2, id);
                        int rows = ps.executeUpdate();
                        System.out.println(rows > 0
                                ? "Quantity updated successfully."
                                : "Product not found.");
                    }
                } else if (choice == 4) {
                    try (PreparedStatement ps = con.prepareStatement(
                            "SELECT * FROM Product WHERE Quantity<10");
                         ResultSet rs = ps.executeQuery()) {
                        boolean found = false;
                        while (rs.next()) {
                            found = true;
                            System.out.println(rs.getInt("ProductID") + " | " +
                                    rs.getString("ProductName") + " | Quantity: " +
                                    rs.getInt("Quantity"));
                        }
                        if (!found) System.out.println("No low-stock products.");
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
