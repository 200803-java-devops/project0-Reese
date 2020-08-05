package reeseBenson.revature.project0;

import java.util.ArrayList;

public class Player {
    private String name;
    private String face;
    private ArrayList<Monster> monsters;

    Player(String name, String face){
        this.name = name;
        this.face = face;
        monsters = new ArrayList<Monster>();
    }

    public String getName(){
        return name;
    }

    public String getFace(){
        return face;
    }

    public static String pickAFace(){
        MyIO io = new MyIO();
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
        MyIO io = new MyIO();
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

    public String toString(){
        String result = "";
        String nl = "\n";
        result += name + nl + face + nl + monsters.size() + nl;
        for(Monster m : monsters){
            result += m.toString() + "﹏\n";
        } 
        return result;
    }

}