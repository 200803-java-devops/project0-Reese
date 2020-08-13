package reeseBenson.revature.project0;

import java.util.ArrayList;
import java.util.Random;

public abstract class Actor {
    private String name;
    private String face;
    protected ArrayList<Monster> monsters;
    protected Monster currentMonster;

    public Actor(String name, String face){
        this.name = name;
        this.face = face;
        monsters = new ArrayList<Monster>();
    }

    public Actor(String saveData){
        String [] data = saveData.split("\n");
        name = data[0];
        face = data[1];
        monsters = new ArrayList<Monster>();
        Integer.parseInt(data[2]);
        for(int i = 3; i<data.length; i+=4){
            Monster curMonster = AllMonsters.getMonster(data[i]);
            curMonster.name = data[i+1];
            curMonster.atk = Integer.parseInt(data[i+2]);
            curMonster.dodgeChance = Integer.parseInt(data[i+3]);
            monsters.add(curMonster);
        }
    }

    public String getName(){
        return name;
    }

    public String getFace(){
        return face;
    }

    public String toString(){
        String result = "";
        String nl = "\n";
        result += name + nl + face + nl + monsters.size() + nl;
        for(Monster m : monsters){
            result += m.toString() + "\n";
        } 
        return result;
    }

    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public Monster getMonster(int index){
        return monsters.get(index);
    }

    public ArrayList<Monster> getMonsters(){
        return new ArrayList<Monster>(monsters);
    }
    
    public Monster selectMonster(){
        Random r = new Random();
        currentMonster = monsters.get(r.nextInt(monsters.size()));
        return currentMonster;
    }

    public Monster getCurrentMonster(){
        return currentMonster;
    }

    public Attack selectAttack(){
        return currentMonster.randomAttack();
    }
}