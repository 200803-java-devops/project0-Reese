package reeseBenson.revature.project0.Driver;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import reeseBenson.revature.project0.AllMonsters;
import reeseBenson.revature.project0.Grid;
import reeseBenson.revature.project0.Monster;
import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;

public class Game {
    MyIO io;
    Player player;
    Grid grid;

    public Game() {
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
                    load();
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
        player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true),
                Player.pickAFace());
        player.firstMonster();
        play();
    }

    public void play() {
        boolean exit = false;
        while (!exit) {
            switch (io.Choice("Would you like to:", "battle", "Catch Monsters", "Save", "return to main menu")) {
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

    public void battle() {
        System.out.println("BATTLE!!!!");
        for (int i = 0; i < 10000000; i++)
            ;
    }

    public void explore() {
        System.out.println("Explore!!");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("0,0", "M");
        hashMap.put("4,2", "M");
        grid = new Grid(hashMap, player.getFace());
        while (true) {
            System.out.println(grid.getPrettyPrint());
            io.mapKey(player.getFace());
            grid.Move(io.charChoice(null, "wsad").charAt(0));
            if(grid.getMonsterColisionFlag()){
                io.write("You found a ...");
                try{
                TimeUnit.SECONDS.sleep(1);
                Monster monster = AllMonsters.getRandom().createInstance();
                player.addMonster(monster);
                io.write(monster.getName() + "!\n" + monster.getArt() + "!\n");
                TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException e){
                    System.err.println("Failed to Sleep-" + e.getMessage());
                }
            }
            if( new Random().nextInt(100) < 10){
                grid.addMonster();
            }
        }
    }

    public void save() {
        System.out.println("Saving...");
        File file = new File(".saves\\save-" + player.getName());
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
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                System.err.println("there was an error closing the file" + e.getMessage());
                return;
            }
        }
    }

    public void load() {
        File saveDirectory = new File(".saves");
        ArrayList<File> files = new ArrayList<File>();
        ArrayList<String> characters = new ArrayList<String>();
        for (File file : saveDirectory.listFiles()) {
            if (file.getName().contains("save-")) {
                files.add(file);
                characters.add(file.getName().substring(5));
            }
        }

        player = new Player(
                io.readFile(files.get(io.Choice("What Character would you like to Play?", characters) - 1)));
        play();
    }
}