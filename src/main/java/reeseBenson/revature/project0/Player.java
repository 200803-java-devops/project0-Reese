package reeseBenson.revature.project0;

import java.util.ArrayList;

public class Player extends Actor {
    MyIO io;
    public Player(String name, String face, MyIO io){
        super(name, face);
        this.io= io;
    }

    public Player(String saveData, MyIO io){
        super(saveData);
        this.io = io;
    }

    public static String pickAFace(MyIO io){
        io = new MyIO();
        int choice = 0;
        boolean ok = false;
        ArrayList<String> faces = new ArrayList<String>();
        faces.add("(•_•)"); 
        faces.add("(^.^)");
        faces.add("(*-*)");
        faces.add("(^w^)");
        while(!ok){
            choice = io.Choice("Pick your face", faces)-1;
            ok = io.yesOrNO("Is this okay?" + faces.get(choice));
        }
        return faces.get(choice);
    }

    public void firstMonster(){
        boolean ok = false;
        int choice = 0;
        ArrayList<String> monstersList = new ArrayList<String>();
        ArrayList<Monster> starters = new ArrayList<Monster>();
        starters.add(new Skizard());
        starters.add(new Faefly());
        starters.add(new Scutter());
        for(Monster mon : starters){
            monstersList.add("\t"+ mon.getType() + "\n" + mon.getArt()); 
        }
        while(!ok){
           choice = io.Choice("Pick a monster", monstersList)-1;
            ok = io.yesOrNO("Is this okay? " + monstersList.get(choice));
        }
        monsters.add(starters.get(choice));       
    }

    @Override
    public Monster selectMonster(){
        ArrayList<String> monsters = new ArrayList<String>();  
        this.monsters.forEach(x -> monsters.add(x.getName() + " the " + x.getType()));
        Monster combatent = this.getMonster(io.Choice("What monster will you choose?", monsters)-1);
        currentMonster = combatent;
        return currentMonster;
    }

    @Override
    public Attack selectAttack(){
        ArrayList<String> attacks = new ArrayList<String>();  
        currentMonster.attacks.forEach(x -> attacks.add(x.getName()));
        return currentMonster.getAttack(io.Choice("Choose an attack", attacks)-1);
    }

}