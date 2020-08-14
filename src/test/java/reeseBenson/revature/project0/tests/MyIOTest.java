package reeseBenson.revature.project0.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StringBufferInputStream;
import org.junit.After;
import org.junit.Test;

import reeseBenson.revature.project0.MyIO;

public class MyIOTest {
    private InputStream in;
    private PrintStream out;
    File file;
    MyIO io;

    public void setup(String input) throws Exception {
        in = new StringBufferInputStream(input);
        file = File.createTempFile("test", null);
        out = new PrintStream(file);
        io = new MyIO(in,out);
        
    }

    @Test
    public void mapKeyTest() throws Exception {
        setup("");
        String expected = "*********************\n* You:(•_•)         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:\n To go back press b:";
        io.mapKey("(•_•)");
        String actual = readFile(file);
        assertEquals(expected, actual);

        file.delete();
        file = File.createTempFile("test", null);
        MyIO io2 = new MyIO(in, new PrintStream(file));
        io2.mapKey("(*-*)");
        expected = "*********************\n* You:(*-*)         *\n* Monster: M        *\n*********************\n\nTo navigate press w (up), s (down),a (left), or d (right) and then press enter:\n To go back press b:";
        actual = readFile(file);
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

    @After
    public void cleanUp() throws IOException {
        out.close();
        in.close();
        file.delete();
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