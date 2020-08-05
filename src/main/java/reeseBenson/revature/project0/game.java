package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    MyIO io;
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
        Player player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true), Player.pickAFace());
        player.firstMonster();
        play(player);
    }

    public void play(Player player){
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
        for(int i=0;i<10000000;i++);
    }

}