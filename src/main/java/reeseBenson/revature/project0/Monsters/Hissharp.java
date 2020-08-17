package reeseBenson.revature.project0.Monsters;

import reeseBenson.revature.project0.Attack;
import reeseBenson.revature.project0.Monster;

public class Hissharp extends Monster {
    /**
     * Creates a new Hissharp
     */
    public Hissharp(){
        super();
        name = "hissharp";
        type = "hissharp";
        art = "  88\n(\\|/)\n /\\";
        health = (maxHealth = 20);
        atk = 4;
        dodgeChance = 2;
        attacks.add(new Attack("Pinchers", 6, 3));
        attacks.add(new Attack("Chop", 8, 1));
    }
    /**
     * Return a new Hissharp
     */
    public Monster createInstance(){
        return new Hissharp();
    }
    
}