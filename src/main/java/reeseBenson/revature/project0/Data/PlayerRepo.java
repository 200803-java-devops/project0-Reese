package reeseBenson.revature.project0.Data;

import java.util.ArrayList;
import java.util.List;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Actors.Player;
import reeseBenson.revature.project0.Factories.PlayerFactory;

public class PlayerRepo {

    private PlayerDAO Dao;
    private MonsterDAO MDAO;
    private MyIO io;
    
    public PlayerRepo(PlayerDAO Dao, MonsterDAO MDao, MyIO io){
        this.io = io;
        this.Dao = Dao;
        this.MDAO = MDao;

    }
    
    public List<Player> getAllFromUser(String userName){
        List<PlayerEntity> players = Dao.getAll(userName);
        List<Player> result = new ArrayList<Player>();
        players.forEach(entity -> result.add(PlayerFactory.createFromEntity(entity, io)));
        return result;
    }

    public void SavePlayer(String username, Player player){
        PlayerEntity entity = Dao.get(username, player.getName());
        if(null != entity ){
            Dao.update(username, entity);
            for(int i = 0; i< player.getMonsters().size(); i++){
                if(i < entity.getMonsters().size()){
                   MDAO.update(new MonsterEntity(player.getMonster(i), entity.getId()));
                }else{
                    MDAO.create(new MonsterEntity(player.getMonster(i), entity.getId()));
                }
            }

        }else{
            Dao.create(username, PlayerFactory.createEntityFromModel(player));
            int playerId = Dao.getId(username, player.getName());
            player.getMonsters().forEach(m -> MDAO.create(new MonsterEntity(m, playerId)));
        }
    }
    
}