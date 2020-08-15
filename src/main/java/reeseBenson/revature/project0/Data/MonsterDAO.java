package reeseBenson.revature.project0.Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MonsterDAO implements IDAO<MonsterEntity, Integer> {

    @Override
    public MonsterEntity get(Integer PKEY) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MonsterEntity> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(MonsterEntity obj) {
        String sql = "UPDATE playermonsters Set monstername = ?, monstertype =?, atk=?, dodgechance=? where monsterId = ?";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getType());
            statement.setInt(3, obj.getAtk());
            statement.setInt(4, obj.getDodge());
            statement.setInt(5, obj.getMonsterId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating Monster " + obj.getName());
            e.printStackTrace();
        }
	}

	@Override
	public void delete(MonsterEntity obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(MonsterEntity obj) {
		String sql = "insert into PlayerMonsters(playerId, monsterName, monsterType, atk, dodgeChance) values (?, ?, ?, ?,?);";
        try {
            PreparedStatement statement = ConnectionUtils.getConnection().prepareStatement(sql);
            statement.setInt(1, obj.getPlayerId());
            statement.setString(2, obj.getName());
            statement.setString(3, obj.getType());
            statement.setInt(4, obj.getAtk());
            statement.setInt(5, obj.getDodge());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating Monster " + obj.getName());
            e.printStackTrace();
        }
		
	}
    
}