package reeseBenson.revature.project0.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringBufferInputStream;

import org.junit.Before;
import org.junit.Test;

import reeseBenson.revature.project0.MyIO;

public class MyIOTest {
    private InputStream in;
    private PrintStream out;
    File file;
    MyIO io;

    public void setup(String input) throws Exception {
        in = new StringBufferInputStream(input);
        file = new File("test");
        file.createNewFile();
        out = new PrintStream(file);
        io = new MyIO(in,out);
        
    }

    @Test
    public void mapKeyTest() throws Exception {
        setup("");
        String expected = "*********************\n* You:(•_•)         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:";
        io.mapKey("(•_•)");
        String actual = readFile(file);
        file.delete();
        assertEquals(expected, actual);

        file = new File("test");
        file.createNewFile();
        MyIO io2 = new MyIO(in, new PrintStream(file));
        io2.mapKey("(*-*)");
        expected = "*********************\n* You:(*-*)         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:";
        actual = readFile(file);
        file.delete();
        assertEquals(expected, actual);
    }

    @Test
    public void charChoice() throws Exception {
        String input ="w\nh\ns\n"; 
        setup(input);
        CharSequence actual = io.charChoice(null, "wsad");
        CharSequence expected ="w";
        assertEquals(expected, actual);

        actual = io.charChoice(null, "wsad");
        expected ="s";
        assertEquals(expected, actual);
    }

    private String readFile(File file){
        String result="";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(reader.ready()){
                result+=reader.readLine();
                if(reader.ready()){
                    result+= "\n";
                }
            }
            reader.close();
        } catch (Exception e) {
           System.err.println("Error opening file to read" + e.getMessage());
        }
        return result;
    }
}