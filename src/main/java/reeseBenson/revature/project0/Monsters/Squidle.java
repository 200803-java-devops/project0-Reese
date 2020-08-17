package reeseBenson.revature.project0.Monsters;

import reeseBenson.revature.project0.Monsters.Attacks.Attack;

public class Squidle extends Monster {
    /**
     * Creates a new squidle
     */
    public Squidle (){
        super();
        name = "squidle";
        type = "squidle";
        art = "(**)\n|  |\n//\\\\";
        health = (maxHealth = 20);
        atk = 1;
        dodgeChance = 2;
        attacks.add(new Attack("Ink Gun", 2, 10));
        attacks.add(new Attack("Watter Squirt", 8, 2));
    }

    /**
     * Returns a new Squidle
     */
    @Override
    public Monster createInstance(){
        return new Bubbla();
    }
    
}