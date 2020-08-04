package reeseBenson.revature.project0;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class myIO {
    private BufferedReader input;
    public myIO() {
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
}