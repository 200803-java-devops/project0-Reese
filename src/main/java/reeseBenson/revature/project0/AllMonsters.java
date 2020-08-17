package reeseBenson.revature.project0;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

import reeseBenson.revature.project0.Monsters.Bubbla;
import reeseBenson.revature.project0.Monsters.Hissharp;
import reeseBenson.revature.project0.Monsters.Squidle;
/**
 * A class used to return new monsters from a string to Monster hashMap of monsters
 */
public class AllMonsters {
    private static HashMap<String, Monster> monsterMap = new HashMap<String,Monster>(){
        /**
        *
        */
        private static final long serialVersionUID = 823155511095156390L;

        {
        put("skizard", new Skizard());
        put("faefly", new Faefly());
        put("scutter", new Scutter());
        put("bubbla", new Bubbla());
        put("squidle", new Squidle());
        put("hissharp", new Hissharp());
        }
    };

    /**
     * Gets a new instance of the monster at the given Key.
     * @param key A string repersentation of the type of monster you want returned ex:"skizard"
     * @return A new monster of the type indicated.
     */
    public static Monster getMonster(String key){
       return monsterMap.get(key.toLowerCase()).createInstance();
    }

    /**
     * Gets a new Instance of a random monster from the list of monsters.
     * @return A new list of monsters.
     */
    public static Monster getRandom(){
       Random random = new Random(); 
       int number = random.nextInt(monsterMap.size());
       Collection<Monster> values = monsterMap.values();
       Monster m  = (Monster) values.toArray()[number];
       return m.createInstance();
    }

}