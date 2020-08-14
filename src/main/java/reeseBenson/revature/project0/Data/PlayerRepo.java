package reeseBenson.revature.project0.Data;

import java.util.ArrayList;
import java.util.List;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;
import reeseBenson.revature.project0.Factories.PlayerFactory;

public class PlayerRepo {

    private PlayerDAO Dao;
    private MyIO io;
    
    public PlayerRepo(PlayerDAO Dao, MyIO io){
        this.io = io;
        this.Dao = Dao;
    }
    
    public List<Player> getAllFromUser(String userName){
        List<PlayerEntity> players = Dao.getAllForUser(userName);
        List<Player> result = new ArrayList<Player>();
        players.forEach(entity -> result.add(PlayerFactory.createFromEntity(entity, io)));
        return result;
    }
    
}