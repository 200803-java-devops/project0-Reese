package reeseBenson.revature.project0.Monsters;

import reeseBenson.revature.project0.Attack;
import reeseBenson.revature.project0.Monster;

public class Bubbla extends Monster {
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

    public Monster createInstance(){
        return new Bubbla();
    }
    
}