package reeseBenson.revature.project0.Actors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import reeseBenson.revature.project0.Monsters.AllMonsters;
import reeseBenson.revature.project0.Monsters.Monster;
import reeseBenson.revature.project0.Monsters.Attacks.Attack;

/**
 * The abstract class repersenting the characters that can hold monsters and battle in the game.
 */
public abstract class Actor {
    private String name;
    private String face;
    protected List<Monster> monsters;
    protected Monster currentMonster;
    /**
     * Sets the Name and Face attributes and creates a new empty list of monsters
     * @param name The Actors name
     * @param face THe string repsentation of the Actor that will be used to repsersent it.
     */
    public Actor(String name, String face){
        this.name = name;
        this.face = face;
        monsters = new ArrayList<Monster>();
    }
    /**
     * Create an actor off of saved data created by the game. 
     * In Enter separated format:
     *  Name\n
     *  Face\n
     *  #of monsters\n
     *  Monster type\n
     *  Monster name\n
     *  Monster Atk\n
     *  Monster Dodgechance\n...
     * @param saveData
     */
    public Actor(String saveData){
        String [] data = saveData.split("\n");
        name = data[0];
        face = data[1];
        monsters = new ArrayList<Monster>();
        Integer.parseInt(data[2]);
        for(int i = 3; i<data.length; i+=4){
            Monster curMonster = AllMonsters.getMonster(data[i]);
            curMonster.setName(data[i+1]);
            curMonster.setAtk(Integer.parseInt(data[i+2]));
            curMonster.setDodgeChance(Integer.parseInt(data[i+3]));
            monsters.add(curMonster);
        }
    }

    /**
     * Create an Actor who has the given Monsters.
     * @param name The name of the actor.
     * @param face the repsentation of the actor.
     * @param monsters the list of monster the actor can battle with.
     */
    public Actor(String name, String face, List<Monster> monsters) {
        this.name = name;
        this.face = face;
        this.monsters = monsters;
	}
    /**
     * Returns the Characters Name.
     * @return The name of the character.
     */
	public String getName(){
        return name;
    }

    /**
     * Returns the Characters Face.
     * @return
     */
    public String getFace(){
        return face;
    }
    
    /**
     * Returns A string repsentation of the Character in Enter seperatored Format.
     * In Enter separated format:
     *  Name\n
     *  Face\n
     *  #of monsters\n
     *  Monster type\n
     *  Monster name\n
     *  Monster Atk\n
     *  Monster Dodgechance\n...
     */
    public String toString(){
        String result = "";
        String nl = "\n";
        result += name + nl + face + nl + monsters.size() + nl;
        for(Monster m : monsters){
            result += m.toString() + "\n";
        } 
        return result;
    }

    /**
     * Adds a monster to the players monster list.
     * @param monster THe monster that will be added to the list.
     */
    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    /**
     * Gets a monster at the given index from the list of monsters.
     * @param index
     * @return
     */
    public Monster getMonster(int index){
        return monsters.get(index);
    }

    /**
     * Returns the list of Monsters the player has access to.
     * @return The players Monster list
     */
    public ArrayList<Monster> getMonsters(){
        return new ArrayList<Monster>(monsters);
    }
    
    /**
     * Selects a monster from the List.
     * @return A random monster from the players monster list list.
     */
    public Monster selectMonster(){
        Random r = new Random();
        currentMonster = monsters.get(r.nextInt(monsters.size()));
        return currentMonster;
    }

    /**
     * Grabs the Players Current monster, the monster being used, or last used in battle.
     * @return
     */
    public Monster getCurrentMonster(){
        return currentMonster;
    }

    /**
     * Selects an attack from the current monster in battle.
     * @return
     */
    public Attack selectAttack(){
        return currentMonster.randomAttack();
    }
}