package reeseBenson.revature.project0;

public abstract class Monster {
    protected String name;
    protected String type;
    protected String art;
    protected int health;
    protected int maxHealth;
    protected int atk;
    protected int dodgeChance;
    //list  of attacks
    
    Monster(){
        health = 100;
        maxHealth = 100;
        atk = 1;
        dodgeChance= 0;
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

    public String getType(){
        return type;
    }

    public String getArt(){
        return art;
    }

    public int AttemptAttack(int chanceToHit){
        //return rng of attack hit chance
        return chanceToHit;
    }

    public String toString(){
        String str;
        str = type + '\n' + name + '\n' + atk + '\n' + dodgeChance;
        return str;
    }


    public int dodge(){
        // rng out off dodge chance 
        return dodgeChance;
    }

    public void takeDamage(int damage){
        health -= damage;
    }

    public void refresh(){
        health = maxHealth;
    }
}