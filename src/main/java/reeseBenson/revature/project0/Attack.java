package reeseBenson.revature.project0;

import java.util.Random;

public class Attack {
    private String name;
    private int hitChance;
    private int power;

    public Attack(String name, int hitChance, int power){
        this.name = name;
        this.hitChance = hitChance;
        this.power = power;
    }

    public String getName(){
        return name;
    }
/**
 * Performs an attack on the given target
 * @param target
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