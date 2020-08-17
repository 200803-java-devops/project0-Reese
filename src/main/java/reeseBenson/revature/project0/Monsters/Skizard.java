package reeseBenson.revature.project0.Monsters;

import reeseBenson.revature.project0.Monsters.Attacks.Attack;

public class Skizard extends Monster {
    /**
     * Creates a new Skiizard
     */
    Skizard(){
        super();
        name="Skizard";
        type="Skizard";
        art="  _\n /•)\n/-|-";
        health = (maxHealth = 25);
        atk = 3;
        dodgeChance = 2;
        attacks.add(new Attack("Fire Breath", 8, 1));
        attacks.add(new Attack("Headbut", 4, 3));
    }

    /**
     * Returns a new instance of a skizard
     */
    public Monster createInstance(){
        return new Skizard();
    }
}