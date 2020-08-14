package reeseBenson.revature.project0.Factories;

import java.io.File;
import java.util.ArrayList;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;
import reeseBenson.revature.project0.Data.PlayerEntity;

public class PlayerFactory {
    
    public static Player create(MyIO io) {
        Player player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true), Player.pickAFace(io), io);
        player.firstMonster();
        return player;
    }

    public static Player localLoad(MyIO io){
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

    public static Player createFromEntity(PlayerEntity entity, MyIO io){
        return new Player(entity.getName(), entity.getFace(), entity.getMonsters(), io);  
    }


    
}