package reeseBenson.revature.project0.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:postgresql://localhost:3254/postgres", "postgres", "mysecretpassword");
    }
    
}