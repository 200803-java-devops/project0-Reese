package reeseBenson.revature.project0;

import java.util.Random;

public class Attack {
    private String name;
    private int hitChance;
    private int power;

    /**
     * Creates a new Attack
     * @param name The name of the attack
     * @param hitChance a number the will be used as the max in a rng to see if an attack hits
     * @param power The multiplier applied to the attackers Atk stat.
     */
    public Attack(String name, int hitChance, int power){
        this.name = name;
        this.hitChance = hitChance;
        this.power = power;
    }

    /**
     * Returns a the name of the attack
     * @return the attacks name
     */
    public String getName(){
        return name;
    }
/**
 * Performs an attack on the given target.
 * @param target the monster being attacked.
 * @param atk the atk stat of the attacking monster.
 */
    public boolean perform(Monster target , int atk){
        if(toHit() > target.dodge()){
            target.takeDamage(power * atk);
            return true;
        }
        return false;
    }

    private int toHit(){
        Random r = new Random();
        return r.nextInt(this.hitChance);
    }
    
}