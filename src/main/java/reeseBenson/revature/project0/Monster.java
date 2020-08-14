package reeseBenson.revature.project0;

import java.util.ArrayList;
import java.util.Random;

public abstract class Monster {
    protected String name;
    protected String type;
    protected String art;
    protected int health;
    protected int maxHealth;
    protected int atk;
    protected int dodgeChance;
    protected ArrayList<Attack> attacks;
    
    public Monster(){
        health = 100;
        maxHealth = 100;
        atk = 1;
        dodgeChance = 1;
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Ram", 5 , 2));
    }

    public Monster createInstance(){
        return new Skizard();
    }

    public int getAtk(){
        return atk;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public String getArt(){
        return art;
    }

    public String toString(){
        String str;
        str = type + '\n' + name + '\n' + atk + '\n' + dodgeChance;
        return str;
    }


    public int dodge(){
        if(dodgeChance > 0){
            return new Random().nextInt(dodgeChance);
        }
        return 0;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public void refresh(){
        health = maxHealth;
    }

    public Attack randomAttack(){
        int choice = new Random().nextInt(attacks.size());
        return attacks.get(choice);
    }

    public Attack getAttack(int i){
        if(attacks.size()-1 < i || i < 0){
            return attacks.get(attacks.size()-1);
        }
        return attacks.get(i);
    }

    public ArrayList<Attack> getAttacks(){
        return attacks;
    }
}