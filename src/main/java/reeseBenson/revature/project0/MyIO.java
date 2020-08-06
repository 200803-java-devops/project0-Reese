package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyIO {
    private BufferedReader input;
    public MyIO() {
        input = new BufferedReader(new java.io.InputStreamReader(System.in));
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
        System.out.println(
                    "\n** ------------------------------------------------------------------------------------------------------------------- **");
            System.out.println(
                    " _______  _______  ___   _  _______  __   __  _______  __    _    ______    ___   _______    _______  _______  _______\n|       ||       ||   | | ||       ||  |_|  ||       ||  |  | |  |    _ |  |   | |       |  |       ||       ||       |\n|    _  ||   _   ||   |_| ||    ___||       ||   _   ||   |_| |  |   | ||  |   | |    _  |  |   _   ||    ___||    ___|\n|   |_| ||  | |  ||      _||   |___ |       ||  | |  ||       |  |   |_||_ |   | |   |_| |  |  | |  ||   |___ |   |___\n|    ___||  |_|  ||     |_ |    ___||       ||  |_|  ||  _    |  |    __  ||   | |    ___|  |  |_|  ||    ___||    ___|\n|   |    |       ||    _  ||   |___ | ||_|| ||       || | |   |  |   |  | ||   | |   |      |       ||   |    |   |\n|___|    |_______||___| |_||_______||_|   |_||_______||_|  |__|  |___|  |_||___| |___|      |_______||___|    |___|");
            System.out.println(
                    "** ------------------------------------------------------------------------------------------------------------------- **\n\n");
            
    }
    public int Choice(String message, ArrayList<String> choices){
        int result = 0;
        while(result==0){
            System.out.println(message);
            for(int i=0; i< choices.size(); i++){
                System.out.println((i+1) + "] " + choices.get(i));
            }
            result = getlineAsInt();
            if(result > choices.size()){
                result = 0;
                System.out.println("please input an integer between 1 and " + choices.size());
            }
        }
        return result;
    }
    public int Choice(String message, String... choices){
        int result = 0;
        while(result==0){
            System.out.println(message);
            for(int i=0; i< choices.length; i++){
                System.out.println((i+1) + "] " + choices[i]);
            }
            result = getlineAsInt();
            if(result > choices.length){
                result = 0;
                System.out.println("please input an integer between 1 and " + choices.length);
            }
        }
        return result;
    }

    public String getXcharsUpperCase(String message, String response, int characters, boolean askIsOk){
        boolean ok = false;
        String result = null;
        while(!ok){
            System.out.println(message);
            try {
                result = input.readLine().toUpperCase().trim().concat("   ").substring(0, characters);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(response !=null){
                System.out.println(response + result);
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
}