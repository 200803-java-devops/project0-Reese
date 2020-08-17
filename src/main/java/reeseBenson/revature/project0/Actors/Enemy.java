package reeseBenson.revature.project0.Actors;

import reeseBenson.revature.project0.Monsters.AllMonsters;

public class Enemy extends Actor {

    /**
     * Creates a new basic enemy Actor.
     */
    public Enemy(){
        super("Enemy", "(o_o)");
        monsters.add(AllMonsters.getRandom().createInstance());
    }
    
}