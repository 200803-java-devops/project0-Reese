package reeseBenson.revature.project0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class Game {
    MyIO io;
    Player player;
    Game(){
        io = new MyIO();
    }

    public void start() {
        boolean play = true;
        // loop back to start screen
        while (play) {
            io.title();
            int input = io.Choice("", "\tStart New Game", "\tLoad Game", "\texit");
            switch (input) {
                case 0:
                    break;
                case 1:
                    create();
                    break;
                case 2:
                    System.out.println("**TODO**");
                    break;
                case 3:
                    System.out.println("\nExiting game");
                    play = false;
                    break;

                default:
                    System.err.println("please input an integer between 1-3");
                    break;
            }
        }
    }

    public void create() {
        player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true), Player.pickAFace());
        player.firstMonster();
        play();
    }

    public void play(){
        boolean exit = false;
        while(!exit){
            switch (io.Choice("Would you like to:", "battle", "Catch Monsters", "Save", "return to main menu")){
                case 1:
                    battle();
                    break;
                case 2:
                    explore();
                    break;
                case 3:
                    save();
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }

    public void battle(){
        System.out.println("BATTLE!!!!");
        for(int i=0;i<10000000;i++);
    }

    public void explore(){
        System.out.println("Explore!!");
        for(int i=0;i<10000000;i++);
    }

    public void save(){
        System.out.println("Saving!!");
        File file = new File("reeseBenson.revature.project0\\.saves\\save-" + player.getName());
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            
        } catch (Exception e) {
           System.err.println("there was an error opening the file " + e.getMessage());
           return;
        }
        try {
            fileWriter.write(player.toString());
        } catch (Exception e) {
            System.err.println("there was an error writting to the file" + e.getMessage());
        } finally{
            try {
                fileWriter.close();
            } catch (Exception e) {
                System.err.println("there was an error closing the file" + e.getMessage());
                return;
            }
        }
    }

}