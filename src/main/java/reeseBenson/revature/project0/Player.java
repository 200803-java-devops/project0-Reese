package reeseBenson.revature.project0;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    private MyIO io;

    /**
     * Creates a player.
     * @param name Players name
     * @param face players face used to repersent player visually, should be one line of ascii art.
     * @param io the MyIO used to handle player input and output.
     */
    public Player(String name, String face, MyIO io){
        super(name, face);
        this.io= io;
    }

    /**
     * Create a player from a Enter seperated values string in the form
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
     * @param io The io handler for the player
     */
    public Player(String saveData, MyIO io){
        super(saveData);
        this.io = io;
    }

    /**
     * Create a player with the given monsters
     * @param name player name
     * @param face players visual repersentation as 1 line of ascii art
     * @param monsters the list of monster the player will have
     * @param io the IO handle for the player
     */
    public Player(String name, String face, List<Monster> monsters, MyIO io) {
        super(name,face,monsters);
        this.io = io;
    }

    /**
     * Picking a face for a player, Used for defaults to allow users to pick a face for their character.
     * @param io the io handler for the selection
     * @return the string repersent the face selected
     */
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

    /**
     * TO be called to let the player pick from starters.
     */
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