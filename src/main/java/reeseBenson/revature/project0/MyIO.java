package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class MyIO {
    private BufferedReader input;
    private PrintStream out;
    public MyIO() {
        input = new BufferedReader(new java.io.InputStreamReader(System.in));
        out = System.out;
    }
    public MyIO(InputStream in, PrintStream out) {
        input = new BufferedReader(new java.io.InputStreamReader(in));
        this.out = out;
    }
    

    public boolean yesOrNO(String message){
        boolean decision = false;
        System.out.println(message + "\n1] yes \n2] no");
        decision = getlineAsInt() == 1 ? true : false;
        return decision;
    }

    public int getlineAsInt(){
        int num=0;
        try {
            num = Integer.parseInt(input.readLine());
            
        } catch (Exception e) {
            System.err.println("Could not convert line to int");
        }
        return num;
    }
    public void title(){
        out.println(
                    "\n** ------------------------------------------------------------------------------------------------------------------- **");
            out.println(
                    " _______  _______  ___   _  _______  __   __  _______  __    _    ______    ___   _______    _______  _______  _______\n|       ||       ||   | | ||       ||  |_|  ||       ||  |  | |  |    _ |  |   | |       |  |       ||       ||       |\n|    _  ||   _   ||   |_| ||    ___||       ||   _   ||   |_| |  |   | ||  |   | |    _  |  |   _   ||    ___||    ___|\n|   |_| ||  | |  ||      _||   |___ |       ||  | |  ||       |  |   |_||_ |   | |   |_| |  |  | |  ||   |___ |   |___\n|    ___||  |_|  ||     |_ |    ___||       ||  |_|  ||  _    |  |    __  ||   | |    ___|  |  |_|  ||    ___||    ___|\n|   |    |       ||    _  ||   |___ | ||_|| ||       || | |   |  |   |  | ||   | |   |      |       ||   |    |   |\n|___|    |_______||___| |_||_______||_|   |_||_______||_|  |__|  |___|  |_||___| |___|      |_______||___|    |___|");
            out.println(
                    "** ------------------------------------------------------------------------------------------------------------------- **\n\n");
            
    }
    public int Choice(String message, List<String> playerNames){
        int result = 0;
        while(result==0){
            out.println(message);
            for(int i=0; i< playerNames.size(); i++){
                out.println((i+1) + "] " + playerNames.get(i));
            }
            result = getlineAsInt();
            if(result > playerNames.size()){
                result = 0;
                out.println("please input an integer between 1 and " + playerNames.size());
            }
        }
        return result;
    }
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
	public void mapKey(String character) {
		out.println("*********************\n* You:"+ character +"         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:\n To go back press b:");
    }

    public void write(String message){
        out.println(message);
    }
    
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