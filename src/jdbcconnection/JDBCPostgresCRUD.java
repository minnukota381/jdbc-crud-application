package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPostgresCRUD {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://localhost:5432/minnudb";
        String user = "postgres";
        String password = "12345";

        Connection con = DriverManager.getConnection(url, user, password);
        
        Statement statement = con.createStatement();
        
        ResultSet r = statement.executeQuery("SELECT * FROM minnutable");
        while (r.next()) {
            int i = r.getInt("id");
            String k = r.getString("name");
            System.out.println("ID: " + i + " Name: " + k);
        }
        
        r.close();
        statement.close();
        con.close();
    }
}
