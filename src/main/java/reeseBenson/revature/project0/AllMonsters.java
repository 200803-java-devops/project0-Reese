package reeseBenson.revature.project0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
    }};

    public static Monster getMonster(String key){
       return monsterMap.get(key.toLowerCase());
    }


}