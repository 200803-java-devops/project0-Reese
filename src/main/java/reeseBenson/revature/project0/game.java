package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class game {
    public static void main(String[] args) {
        boolean play = true;
        // loop back to start screen
        System.out.print("\033[H\033[2J");
        while (play) {
            System.out.println(
                    "\n** ------------------------------------------------------------------------------------------------------------------- **");
            System.out.println(
                    " _______  _______  ___   _  _______  __   __  _______  __    _    ______    ___   _______    _______  _______  _______\n|       ||       ||   | | ||       ||  |_|  ||       ||  |  | |  |    _ |  |   | |       |  |       ||       ||       |\n|    _  ||   _   ||   |_| ||    ___||       ||   _   ||   |_| |  |   | ||  |   | |    _  |  |   _   ||    ___||    ___|\n|   |_| ||  | |  ||      _||   |___ |       ||  | |  ||       |  |   |_||_ |   | |   |_| |  |  | |  ||   |___ |   |___\n|    ___||  |_|  ||     |_ |    ___||       ||  |_|  ||  _    |  |    __  ||   | |    ___|  |  |_|  ||    ___||    ___|\n|   |    |       ||    _  ||   |___ | ||_|| ||       || | |   |  |   |  | ||   | |   |      |       ||   |    |   |\n|___|    |_______||___| |_||_______||_|   |_||_______||_|  |__|  |___|  |_||___| |___|      |_______||___|    |___|");
            System.out.println(
                    "** ------------------------------------------------------------------------------------------------------------------- **\n\n");
            System.out.println("\t 1] Start New Game\n\t 2] Load Game\n\t 3] exit");
            BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
            int input = 0;
            try {
                input = Integer.parseInt(in.readLine());
            } catch (Exception e) {
                System.err.println("please input an integer between 1-3");
            }
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
                    System.out.print("\033[H\033[2J");
                    System.out.println("\bExiting game");
                    play = false;
                    break;

                default:
                    System.err.println("please input an integer between 1-3");
                    break;
            }
        }
    }

    public static void create() {
        BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
        boolean ok = false;
        myIO io = new myIO();
        while(!ok){
            String name = null;
            System.out.println("What is your name? [3 char]");
            try {
                name = in.readLine().toUpperCase().trim().concat("   ").substring(0, 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Your Name is " + name + "!");
            ok = io.yesOrNO("Is this okay?");  
        }
        ok = false;
        ArrayList<String> faces = new ArrayList<String>() {
            {
            add("(•_•)"); 
            add("(^.^)");
            add("(*-*)");
            add("(^w^)");
            }
        };
        while(!ok){
            int face = 0;
            face = io.Choice("pick your face", faces)-1;
            ok = io.yesOrNO("Is this okay?" + faces.get(face));
        }
    }

}