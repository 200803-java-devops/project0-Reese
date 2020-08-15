package reeseBenson.revature.project0.Factories;

import java.util.ArrayList;
import java.util.List;

import reeseBenson.revature.project0.AllMonsters;
import reeseBenson.revature.project0.Monster;
import reeseBenson.revature.project0.Data.MonsterEntity;

public class MonsterFactory {
    public static List<Monster> createFromEntities(List<MonsterEntity> entities){
        List<Monster> result = new ArrayList<Monster>();
        entities.forEach(e -> result.add(createFromEntity(e)));
        return result;
    }
    
    public static Monster createFromEntity(MonsterEntity entity){
        Monster result = AllMonsters.getMonster(entity.getType());
        result.setName(entity.getName());
        return result;  
    }

	public static List<MonsterEntity> createEntityFromList(ArrayList<Monster> monsters) {
        List<MonsterEntity> result = new ArrayList<MonsterEntity>();
        monsters.forEach(m -> result.add(new MonsterEntity(m, 0)));
        return result;
	}
}