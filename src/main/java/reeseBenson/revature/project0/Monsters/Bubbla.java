package reeseBenson.revature.project0.Monsters;

import reeseBenson.revature.project0.Monsters.Attacks.Attack;

public class Bubbla extends Monster {
    /**
     * Creates a new bubbla Monster
     */
    public Bubbla(){
        super();
        name = "bubbla";
        type = "bubbla";
        art = " ---\n|O.O|\n ---";
        health = (maxHealth = 40);
        atk = 1;
        dodgeChance = 1;
        attacks.add(new Attack("Bubble Burst", 10, 1));
        attacks.add(new Attack("Puff", 4, 3));
    }
    
    /**
     * Returns a new Bubbla
     */
    @Override
    public Monster createInstance(){
        return new Bubbla();
    }
    
}