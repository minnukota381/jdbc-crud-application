package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMySQLCRUD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/minnudb";
        String username = "root"; 
        String password = "12345";

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select operation: ");
        System.out.println("1. Select");
        System.out.println("2. Insert");
        System.out.println("3. Delete");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            switch (choice) {
                case 1:
                    String selectQuery = "SELECT * FROM minnutable";
                    ResultSet resultSet = statement.executeQuery(selectQuery);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        System.out.println("ID: " + id + ", Name: " + name);
                    }
                    resultSet.close();
                    break;

                case 2:
                    System.out.print("Enter ID to insert: ");
                    int userInputId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name to insert: ");
                    String userInputName = scanner.nextLine();

                    String insertQuery = "INSERT INTO minnutable (id, name) VALUES (" + userInputId + ", '" + userInputName + "')";
                    int rowsInserted = statement.executeUpdate(insertQuery);
                    if (rowsInserted > 0) {
                        System.out.println("A new record inserted successfully.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();

                    String deleteQuery = "DELETE FROM minnutable WHERE id = " + deleteId;
                    int rowsDeleted = statement.executeUpdate(deleteQuery);
                    if (rowsDeleted > 0) {
                        System.out.println("The record was deleted successfully.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
