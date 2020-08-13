package reeseBenson.revature.project0.Actors;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Player;

public class PlayerFactory {

    public static Player create(MyIO io) {
        Player player = new Player(io.getXcharsUpperCase("What is your Name? [3 chars max]", "Hello ", 3, true), Player.pickAFace(io), io);
        player.firstMonster();
        return player;
    }
    
}