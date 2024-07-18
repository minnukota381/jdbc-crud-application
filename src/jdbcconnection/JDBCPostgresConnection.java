package jdbcconnection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPostgresConnection {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/minnudb";
        String user = "postgres";
        String password = "12345";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Select operation: ");
        System.out.println("1. Insert");
        System.out.println("2. Select");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        int ch = scan.nextInt();
        scan.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            switch (ch) {
                case 1:
                    insertOperation(conn);
                    break;
                case 2:
                    readOperation(conn);
                    break;
                case 3:
                    // updateOperation(conn);
                    break;
                case 4:
                    deleteOperation(conn);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readOperation(Connection conn) {
        String sql = "SELECT * FROM minnutable";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOperation(Connection conn) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter id: ");
        int id = s.nextInt();
        s.nextLine(); // Consume newline character left in buffer

        System.out.println("Enter name: ");
        String name = s.nextLine();

        String sql = "INSERT INTO minnutable (id, name) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new record has been inserted successfully.");
            } else {
                System.out.println("Insert operation failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOperation(Connection conn) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter id to delete: ");
        int id = s.nextInt();
        String sql = "DELETE FROM minnutable WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("Delete operation failed. Record with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
