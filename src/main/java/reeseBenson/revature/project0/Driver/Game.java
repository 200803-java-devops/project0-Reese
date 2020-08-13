package reeseBenson.revature.project0.Driver;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import reeseBenson.revature.project0.AllMonsters;
import reeseBenson.revature.project0.Enemy;
import reeseBenson.revature.project0.GameComponents.Battle;
import reeseBenson.revature.project0.GameComponents.Grid;
import reeseBenson.revature.project0.Monster;
import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;
import reeseBenson.revature.project0.Actors.PlayerFactory;

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
            play = newOrLoad();
        }
    }

    private boolean newOrLoad(){
        int input = io.Choice("", "\tStart New Game", "\tLoad Game", "\texit");
            switch (input) {
                case 0:
                    break;
                case 1:
                    player = PlayerFactory.create(io);
                    play();
                    break;
                case 2:
                    player = load();
                    play();
                    break;
                case 3:
                    System.out.println("\nExiting game");
                    return false;

                default:
                    System.err.println("please input an integer between 1-3");
                    break;
            }
            return true;
    }

    private  Player newOrLoad(Player p){
        boolean picking = true;
        while(picking){
            int input = io.Choice("", "\tStart New Game", "\tLoad Game", "\texit");
            switch (input) {
                case 0:
                break;
                case 1:
                p = PlayerFactory.create(io);
                save(p);
                return p;
                case 2:
                p = load();
                return p;
                case 3:
                System.out.println("\nExiting game");
                picking = false;
                break;
                
                default:
                System.err.println("please input an integer between 1-3");
                break;
            }
        }
            return null;
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
                    save(player);
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }

    public void battle() {
        Battle combat;
        if(io.Choice("Would you like to battle a friend or a CPU", "friend", "CPU") ==1){
            Player player2 = null;
            player2 = newOrLoad(player2);
            if(player2 == null){
                return;
            }
            combat = new Battle(player, player2, io);

        }else{
            combat = new Battle(player, new Enemy(), io);
        }
        System.out.println("BATTLE!!!!");
        combat.Start();
    }

    public void explore() {
        System.out.println("Explore!!");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("0,0", "M");
        hashMap.put("4,2", "M");
        grid = new Grid(hashMap, player.getFace());
        while (true) {
            io.write(grid.getPrettyPrint());
            io.mapKey(player.getFace());
            char choice = io.charChoice(null, "wsadb").charAt(0);
            if(choice =='b')
                break;
            grid.Move(choice);
            handleCollision();
            generateMonsters();
            
        }
    }

    private void handleCollision(){
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
    }

    private void generateMonsters(){
        if( new Random().nextInt(100) < 10){
            grid.addMonster();
        }
    }

    public void save(Player p) {
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
            fileWriter.write(p.toString());
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

    public Player load() {
        File saveDirectory = new File(".saves");
        ArrayList<File> files = new ArrayList<File>();
        ArrayList<String> characters = new ArrayList<String>();
        for (File file : saveDirectory.listFiles()) {
            if (file.getName().contains("save-")) {
                files.add(file);
                characters.add(file.getName().substring(5));
            }
        }

        return new Player(io.readFile(files.get(io.Choice("What Character would you like to Play?", characters) - 1)), io);
    }
}