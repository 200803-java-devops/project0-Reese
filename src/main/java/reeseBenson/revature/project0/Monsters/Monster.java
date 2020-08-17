package reeseBenson.revature.project0.Monsters;

import java.util.ArrayList;
import java.util.Random;

import reeseBenson.revature.project0.Monsters.Attacks.Attack;

/**
 * An abstract class repersenting A monster that an Actor can use to battle with.
 */
public abstract class Monster {
    protected String name;
    protected String type;
    protected String art;
    protected int health;
    protected int maxHealth;
    protected int atk;
    protected int dodgeChance;
    protected ArrayList<Attack> attacks;
    
    /**
     * The default Super constuctor for all Extending monsters
     */
    public Monster(){
        health = 100;
        maxHealth = 100;
        atk = 1;
        dodgeChance = 1;
        attacks = new ArrayList<Attack>();
        attacks.add(new Attack("Ram", 5 , 2));
    }

    /**
     * Get the monsters dodge chance
     * @return the chance a monster will dodge.
     */
    public int getDodgeChance() {
        return dodgeChance;
    }

    /**
     * Sets the dodge chance
     * @param dodgeChance the dodge chance to set
     */
    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }
    
    /**
     * Creates an instance of the type of monster, should be overriden by sub class return null by default
     * @return A new instance of this monsters type.
     */
    public Monster createInstance(){
        return null;
    }

    /**
     * The atk of the monster is returned
     * @return the monsters attack
     */
    public int getAtk(){
        return atk;
    }
    
    /**
     * The Atk of the monster is set
     * @param atk
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

/**
 *  Name getter function. 
 * @return the name of the Monster.
 */
    public String getName(){
        return name;
    }
/**
 * Name setter funtion
 * @param name the new name of the Monster.
 */
    public void setName(String name){
        this.name = name;
    }
/**
 * return the monsters type
 * @return
 */
    public String getType(){
        return type;
    }
/**
 * Return if the monster has health above zero
 * @return a boolean repesentation of the monsters life
 */
    public boolean isAlive(){
        return health > 0;
    }
/**
 * THe monsters asci art to be used in battle
 * @return
 */
    public String getArt(){
        return art;
    }
/**
 * A string repersentation of the monster in Enter seperated format
 * Type
 * Name
 * Atk
 * Dodge
 */
    public String toString(){
        String str;
        str = type + '\n' + name + '\n' + atk + '\n' + dodgeChance;
        return str;
    }

/**
 * A rng value to see if a monster can dodge.
 * @return THe dodge roll.
 */
    public int dodge(){
        if(dodgeChance > 0){
            return new Random().nextInt(dodgeChance);
        }
        return 0;
    }
/**
 * THe monsters health is decreased by the given amount
 * @param damage
 */
    public void takeDamage(int damage){
        health -= damage;
    }
/**
 * The monsters current health getter.
 * @return the current health
 */
    public int getHealth(){
        return health;
    }
/**
 * The monsters max health getter.
 * @return
 */
    public int getMaxHealth(){
        return maxHealth;
    }
/**
 * Return the monster to full health
 */
    public void refresh(){
        health = maxHealth;
    }
/**
 * Select an attack randomly
 * @return
 */
    public Attack randomAttack(){
        int choice = new Random().nextInt(attacks.size());
        return attacks.get(choice);
    }
/**
 * Return a specified attack, or its last attack if invalid index.
 * @param i the attack wanted
 * @return
 */
    public Attack getAttack(int i){
        if(attacks.size()-1 < i || i < 0){
            return attacks.get(attacks.size()-1);
        }
        return attacks.get(i);
    }
/**
 * Return the list of attacks
 * @return the list of attacks.
 */
    public ArrayList<Attack> getAttacks(){
        return attacks;
    }
}