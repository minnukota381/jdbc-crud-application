package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM minnutable";
            
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("ID: " + id + ", Name: " + name);
            }

            String insertQuery = "INSERT INTO minnutable (id, name) VALUES (3, 'Kavya')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("A new record inserted successfully.");
            }

            String deleteQuery = "DELETE FROM minnutable WHERE id = 1";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("The record was deleted successfully.");
            }
                        
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
