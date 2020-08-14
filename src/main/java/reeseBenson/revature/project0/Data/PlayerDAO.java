package reeseBenson.revature.project0.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reeseBenson.revature.project0.AllMonsters;
import reeseBenson.revature.project0.Monster;

public class PlayerDAO implements IDAO<PlayerEntity, Integer> {

    public List<PlayerEntity> getAllForUser(String UserName) {
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
                List<Monster> monsters = new ArrayList<Monster>();
                while(!resultSet.isAfterLast() && name.equals(resultSet.getString("charactername"))){
                 String type = resultSet.getString("monstertype");
                 Monster m = AllMonsters.getMonster(type).createInstance();
                 m.setName(resultSet.getString("monstername"));
                  monsters.add(m);
                  resultSet.next();
                }
                result.add(new PlayerEntity(face, name, monsters));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public PlayerEntity get(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PlayerEntity> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(PlayerEntity obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(PlayerEntity obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void create(PlayerEntity obj) {
        // TODO Auto-generated method stub

    }
    
}