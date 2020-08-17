package reeseBenson.revature.project0.Factories;

import java.io.File;
import java.util.ArrayList;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;
import reeseBenson.revature.project0.Data.PlayerEntity;

public class PlayerFactory {
    /**
     * Creates a new player from the entires in the provided input stream.
     * @param io The class that handles the IO for player creation
     * @return a new player.
     */
    public static Player create(MyIO io) {
        Player player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true), Player.pickAFace(io), io);
        player.firstMonster();
        return player;
    }
    /**
     * Finds all save files from local memory and presents them to the output stream, and loads the one the player selects into a new player object.
     * @param io The class that will handle the io for this players creation
     * @return A new player with the data from the local file.
     */
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

    /**
     * Creates a player from an entity and Io stream.
     * @param entity the entity to get player data from
     * @param io the class that will handle the player IO
     * @return a new player
     */
    public static Player createFromEntity(PlayerEntity entity, MyIO io){
        return new Player(entity.getName(), entity.getFace(),MonsterFactory.createFromEntities(entity.getMonsters()), io);  
    }
/**
 * Creates a new entity from the Player
 * @param p the Player to be returned as an entity 
 * @return A new entity from the player.
 */
    public static PlayerEntity createEntityFromModel(Player p){
        return new PlayerEntity(p.getFace(), p.getName(), 0, MonsterFactory.createEntityFromList(p.getMonsters()));
    }


    
}