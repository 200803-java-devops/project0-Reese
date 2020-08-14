package reeseBenson.revature.project0;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp {

    public static void main(String[] args) throws SQLException {
       Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Iwant1turtlePlease");
       Statement s = c.createStatement();
       ResultSet r = s.executeQuery("Select currentTime");
        r.next();
        System.out.println(r);
    }
    
}