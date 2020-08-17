package reeseBenson.revature.project0.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PlayerDAO implements IUserBasedDAO<PlayerEntity, String> {

    @Override
    public List<PlayerEntity> getAll(String UserName) {
        List<PlayerEntity> result = new ArrayList<PlayerEntity>();
        String sql = "Select * from PlayerCharacters where username = ?";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, UserName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            while(!resultSet.isAfterLast()){
                String name = resultSet.getString("charactername");
                String face = resultSet.getString("face");
                int id = resultSet.getInt("playerID");
                List<MonsterEntity> monsters = new ArrayList<MonsterEntity>();
                while(!resultSet.isAfterLast() && name.equals(resultSet.getString("charactername"))){
                 String type = resultSet.getString("monstertype");
                 String Monstername = resultSet.getString("monstername");
                 int atk = resultSet.getInt("atk");
                 int dodgeChance = resultSet.getInt("dodgeChance");
                 int monsterId = resultSet.getInt("monsterid");
                 MonsterEntity m = new MonsterEntity(id, Monstername, type, atk, dodgeChance, monsterId); 
                  monsters.add(m);
                  resultSet.next();
                }
                result.add(new PlayerEntity(face, name, id, monsters));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public PlayerEntity get(String Username, String characterName) {
        PlayerEntity result = null;
        String sql = "Select * from PlayerCharacters where username = ? and charactername = ?";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, Username);
            statement.setString(2, characterName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
                String name = resultSet.getString("charactername");
                String face = resultSet.getString("face");
                int id = resultSet.getInt("playerID");
                List<MonsterEntity> monsters = new ArrayList<MonsterEntity>();
                while(!resultSet.isAfterLast() && name.equals(resultSet.getString("charactername"))){
                    String type = resultSet.getString("monstertype");
                    String Monstername = resultSet.getString("monstername");
                    int atk = resultSet.getInt("atk");
                    int dodgeChance = resultSet.getInt("dodgeChance");
                    int monsterId = resultSet.getInt("monsterid");
                    MonsterEntity m = new MonsterEntity(id, Monstername, type, atk, dodgeChance, monsterId);
                    monsters.add(m);
                    resultSet.next();
                }
                result = new PlayerEntity(face, name, id, monsters);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        return result;
    }

    public int getId(String Username, String characterName) {
        int result = 0;
        String sql = "Select playerId from Player where username = ? and charactername = ?";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, Username);
            statement.setString(2, characterName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            result = resultSet.getInt("playerId");   
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(String username, PlayerEntity obj) {
        String sql = "Update Player set face=? where username=? and charactername = ?";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(2, username);
            statement.setString(3, obj.getName());
            statement.setString(1, obj.getFace());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("error updating player");
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void delete(String username, PlayerEntity obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void create(String username, PlayerEntity obj) {
        String sql = "insert into Player(Username, CharacterName, Face) values (?,?,?);";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, obj.getName());
            statement.setString(3, obj.getFace());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("error inserting into player");
            e.printStackTrace();
        }
    }
    
}