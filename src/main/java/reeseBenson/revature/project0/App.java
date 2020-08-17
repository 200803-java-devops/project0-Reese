package reeseBenson.revature.project0;

import reeseBenson.revature.project0.Driver.Game;

public class App 
{

    /**
     * The driver of the main game. Creates a new game to System in out and runs it.
     * @param args T
     */
    public static void main( String[] args )
    {
      Game game = new Game(new MyIO());
      game.start();
    }
}