package reeseBenson.revature.project0.Factories;

import java.util.ArrayList;
import java.util.List;

import reeseBenson.revature.project0.AllMonsters;
import reeseBenson.revature.project0.Monster;
import reeseBenson.revature.project0.Data.MonsterEntity;
/**
 * This class is designed to create new monsters.
 */
public class MonsterFactory {
    /**
     * This function returns a new list of monsters built from the entities provided.
     * @param entities A list of Monster entities to convert to Monsters
     * @return A List of Monsters matching the list of entities
     */
    public static List<Monster> createFromEntities(List<MonsterEntity> entities){
        List<Monster> result = new ArrayList<Monster>();
        entities.forEach(e -> result.add(createFromEntity(e)));
        return result;
    }

    /**
     * This class returns a new Monster created from the given Monster entity. 
     * @param entity A MonsterEntity
     * @return A new Monster Matching the provided entity
     */
    public static Monster createFromEntity(MonsterEntity entity){
        Monster result = AllMonsters.getMonster(entity.getType());
        result.setName(entity.getName());
        return result;  
    }

    /**
     * Calls the Monster entity constuctor on each of a list of provided Monsters.
     * @param monsters A list of Monster to convert to entities
     * @return
     */
	public static List<MonsterEntity> createEntityFromList(ArrayList<Monster> monsters) {
        List<MonsterEntity> result = new ArrayList<MonsterEntity>();
        monsters.forEach(m -> result.add(new MonsterEntity(m, 0)));
        return result;
	}
}