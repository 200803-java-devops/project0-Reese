package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
/**
 * The Class that handle the IO for the Game class.
 * It has serveral functions to write out specifiec strings.
 * It also handles File IO.
 */
public class MyIO {
    private BufferedReader input;
    private PrintStream out;
    /**
     * Create MyIO object using a Reader to STDIn and a PrintStream to STDOut
     */
    public MyIO() {
        input = new BufferedReader(new java.io.InputStreamReader(System.in));
        out = System.out;
    }
    /**
     * Creates MyIO object with a reader to the passed in input stream and a uses the pasted in printstream as the out.
     * @param in
     * @param out
     */
    public MyIO(InputStream in, PrintStream out) {
        input = new BufferedReader(new java.io.InputStreamReader(in));
        this.out = out;
    }
    
    /**
     * Print a yes or no message to output and handles a response from the input.
     * If 1 is not entered it assumes no was intended and returns false.
     * @param message returns true for yes, flase for no
     * @return
     */
    public boolean yesOrNO(String message){
        boolean decision = false;
        System.out.println(message + "\n1] yes \n2] no");
        decision = getlineAsInt() == 1 ? true : false;
        return decision;
    }

    /**
     * Returns an interger rpersentation of the input.
     * @return
     */
    public int getlineAsInt(){
        int num=0;
        try {
            num = Integer.parseInt(input.readLine());
            
        } catch (Exception e) {
            System.err.println("Could not convert line to int");
        }
        return num;
    }

    /** 
    *Prints the game title.
    */
    public void title(){
        out.println(
                    "\n** ------------------------------------------------------------------------------------------------------------------- **");
            out.println(
                    " _______  _______  ___   _  _______  __   __  _______  __    _    ______    ___   _______    _______  _______  _______\n|       ||       ||   | | ||       ||  |_|  ||       ||  |  | |  |    _ |  |   | |       |  |       ||       ||       |\n|    _  ||   _   ||   |_| ||    ___||       ||   _   ||   |_| |  |   | ||  |   | |    _  |  |   _   ||    ___||    ___|\n|   |_| ||  | |  ||      _||   |___ |       ||  | |  ||       |  |   |_||_ |   | |   |_| |  |  | |  ||   |___ |   |___\n|    ___||  |_|  ||     |_ |    ___||       ||  |_|  ||  _    |  |    __  ||   | |    ___|  |  |_|  ||    ___||    ___|\n|   |    |       ||    _  ||   |___ | ||_|| ||       || | |   |  |   |  | ||   | |   |      |       ||   |    |   |\n|___|    |_______||___| |_||_______||_|   |_||_______||_|  |__|  |___|  |_||___| |___|      |_______||___|    |___|");
            out.println(
                    "** ------------------------------------------------------------------------------------------------------------------- **\n\n");
            
    }

    /**
     * Present the player with a message and Choices labeled as intergers, It recives the input and returns the integer selected stating at 1.
     * @param message A message to print to the players before presenting the choice
     * @param options The options a user can select from
     * @return
     */
    public int Choice(String message, List<String> options){
        int result = 0;
        while(result==0){
            out.println(message);
            for(int i=0; i< options.size(); i++){
                out.println((i+1) + "] " + options.get(i));
            }
            result = getlineAsInt();
            if(result > options.size()){
                result = 0;
                out.println("please input an integer between 1 and " + options.size());
            }
        }
        return result;
    }

    /**
     * Present the player with a message and Choices labeled as intergers, It recives the input and returns the integer selected stating at 1.
     * @param message A message to print to the user before presenting the choice
     * @param choices The choice a user can make as a vararg.
     * @return
     */
    public int Choice(String message, String... choices){
        int result = 0;
        while(result==0){
            out.println(message);
            for(int i=0; i< choices.length; i++){
                out.println((i+1) + "] " + choices[i]);
            }
            result = getlineAsInt();
            if(result > choices.length){
                result = 0;
                out.println("please input an integer between 1 and " + choices.length);
            }
        }
        return result;
    }

    /**
     * Grabs the number of characters specified as an upercase string
     * @param message A message to print to prompt the user input
     * @param response A response to print to user upon accepted input followed by the input they entered
     * @param characters The number of character to accept
     * @param askIsOk A bool deterimine to ask the player if they are satified with thier input.
     * @return the user input
     */
    public String getXcharsUpperCase(String message, String response, int characters, boolean askIsOk){
        boolean ok = false;
        String result = null;
        while(!ok){
            out.println(message);
            try {
                result = input.readLine().toUpperCase().trim().concat("   ").substring(0, characters);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(response !=null){
                out.println(response + result);
            }
            if(askIsOk){
                ok = yesOrNO("Is this okay?");  
            }else{
                ok = true;
            }
        }
        return result;
    }

    /**
     * Returns a string repsersentation of the entire file.
     * @param file the file to be read
     * @return a string repersentation of the entire file.
     */
    public String readFile(File file){
        String result="";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(reader.ready()){
                result+=reader.readLine() + "\n";
            }
            reader.close();
        } catch (Exception e) {
           System.err.println("Error opening file to read" + e.getMessage());
        }
        return result;
    }
    /**
     * Prints the key to the exploration map
     * @param character a repersentation of the character
     */
	public void mapKey(String character) {
		out.println("*********************\n* You:"+ character +"         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:\n To go back press b:");
    }

    /**
     * Writes a message to the user
     * @param message the message to be written
     */
    public void write(String message){
        out.println(message);
    }
    
    /**
     * Prints a message to a user followed by a number of characters for the user to select from
     * @param message the message to print to the user
     * @param c a string used as an char[] of the options to be selected from
     * @return A char sequecence containing the chosen character
     */
    public CharSequence charChoice(String message, String c){
        CharSequence choice = "\n";
        do {
            if(message != null){
                out.println(message);
            }
            try {
                String line = input.readLine(); 
                choice = line.length() > 0 ? line.subSequence(0, 1) : "\n";
            } catch (IOException e) {
                System.err.println("Failed to read input");
                e.printStackTrace();
            }
        } while (!c.contains(choice));
        return choice;
    }

    /**
     * Gets a line of input from the inputstream
     * @param string A prompt to output to the user
     * @return the line enter from the input stream
     */
	public String getLine(String string) {
        out.print(string);
        String result = "";
         try {
            result = input.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
}