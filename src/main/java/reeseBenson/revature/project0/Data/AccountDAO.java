package reeseBenson.revature.project0.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public boolean Exists(String username, String password) {
        //TODO add password.
        String sql = "Select username from Account where username = ? and pwd = ?;";
        boolean result = false;
        PreparedStatement statement;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = !rs.isAfterLast();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        return result;
    }

    public void Create(String username, String password){
        String sql = "insert into Account (username, pwd) values(?, ?);";
        PreparedStatement statement;
        try {
            statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
}