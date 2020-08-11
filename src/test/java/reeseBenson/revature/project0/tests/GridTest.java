package reeseBenson.revature.project0.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import reeseBenson.revature.project0.Grid;

public class GridTest 
{
    String SpaceHorizontal = " ------- ";
    String playerFace1="(•_•)";
    String playerFace2="(*-*)";    
    String EmptySpace= "|       |";
    String emptyGrid1 ="", emptyGrid2 = "", monsterGrid1 = "";    
    String HorizontalRow = SpaceHorizontal + SpaceHorizontal + SpaceHorizontal + SpaceHorizontal + SpaceHorizontal + "\n";
    @Before
    public void Setup(){
        String EmptyRow =  EmptySpace + EmptySpace + EmptySpace + EmptySpace + EmptySpace + "\n"; 
        String CompleteEmptyRow =HorizontalRow + EmptyRow + EmptyRow + EmptyRow;
        for(int i =0; i<5;i++){
            if(i!=2){
                emptyGrid1 += CompleteEmptyRow;
                emptyGrid2 += CompleteEmptyRow;
            }else{
                emptyGrid1 += HorizontalRow + EmptyRow;
                emptyGrid2 += HorizontalRow + EmptyRow;
                for(int j =0; j<5;j++){
                    if(j!=2){
                        emptyGrid1 += EmptySpace;
                        emptyGrid2 += EmptySpace;
                    }
                    else{
                        emptyGrid1 += "| "+playerFace1 +" |";
                        emptyGrid2 += "| "+playerFace2 +" |";
                    }
                }
                emptyGrid2 += "\n" + EmptyRow;
                emptyGrid1 += "\n" + EmptyRow;
            }
        }
   }
   
    @Test
    public void EmptyGridPrettyPrintTest()
    {
        Grid map = new Grid(playerFace1);
        String expected = emptyGrid1;
        String actual = map.getPrettyPrint();
        assertEquals(expected, actual);

        map = new Grid(playerFace2);
        expected = emptyGrid2;
        actual = map.getPrettyPrint();
        assertEquals(expected, actual);
    }

    @Test
    public void GridWithMonsterPrettyPrintTest()
    {
        char[] temp= emptyGrid1.toCharArray();
        //Replace space 0,0 witch is 2 lines down 
        //with M since each grid space has a length of 9 
        //and m will be in the middle add 4
        temp[HorizontalRow.length()*2+4] = 'M';
        monsterGrid1 = new String(temp);
        temp[HorizontalRow.length()*2+4] = ' ';
        //Replace space 1,1 (witch is 6 lines down because each row is 4 lines and its 2 lines to center)
        // with M, since each grid space has a length of 9 and m will be in the middle add 4
        temp[HorizontalRow.length()*6+4+EmptySpace.length()] = 'M';
        String monsterGrid2 = new String(temp);

        HashMap<String,String> spaces = new HashMap<String,String>();
        spaces.put("0,0", "M");
        Grid map = new Grid(spaces, playerFace1);
        String expected = monsterGrid1;
        String actual = map.getPrettyPrint();
        assertEquals(expected, actual);

        spaces = new HashMap<String,String>();
        spaces.put("1,1", "M");
        map = new Grid(spaces, playerFace1);
        expected = monsterGrid2;
        actual = map.getPrettyPrint();
        assertEquals(expected, actual);
    }

    @Test
    public void gridMoveUp(){
        HashMap<String, String> spaces = new HashMap<String,String>();
        spaces.put("0,0", "M");
        Grid map = new Grid(spaces, playerFace1);
        HashMap<String, String> expected = new HashMap<String,String>();
        expected.put("1,0", "M");
        expected.put("2,2",playerFace1);
        map.Move('w');
        HashMap<String, String> actual = map.getSpaces();

        assertEquals(expected, actual);

        spaces.clear();
        spaces.put("4,2", "M");
        expected.remove("1,0");
        Grid map2 = new Grid(spaces, playerFace1);
        map2.Move('w');
        actual = map2.getSpaces();
        assertEquals(expected, actual);

        spaces.clear();
        spaces.put("4,2", "M");
        Grid map3 = new Grid(spaces, playerFace1);
        map3.Move('w');
        actual = map3.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms up thus player moved down
        spaces.put("1,1", "M");
        spaces.put("3,1", "M");
        expected.put("2,1", "M");
        expected.put("4,1", "M");
        map3.Move('w');
        actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms up thus player moved down 
        expected.remove("2,1", "M");
        expected.remove("4,1", "M");
        expected.put("3,1", "M");
        map3.Move('w');
        actual = map.getSpaces();
        assertEquals(expected, actual);
    }
    
    @Test
    public void moveDownTest(){
        // Should move down 1 space
        HashMap<String, String> spaces = new HashMap<String,String>();
        spaces.put("1,0", "M");
        Grid map = new Grid(spaces, playerFace1);
        HashMap<String, String> expected = new HashMap<String,String>();
        expected.put("0,0", "M");
        expected.put("2,2",playerFace1);
        map.Move('s');
        HashMap<String, String> actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move off map and be deleted
        map.Move('s');
        actual =map.getSpaces();
        expected.remove("0,0");
        assertEquals(expected, actual);

        //should move into player and be deleted
        spaces.put("3,2", "M");
        map.Move('s');
        actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms down thus player moved up 
        spaces.put("1,1", "M");
        spaces.put("3,1", "M");
        expected.put("0,1", "M");
        expected.put("2,1", "M");
        map.Move('s');
        actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms down thus player moved up 
        expected.remove("0,1", "M");
        expected.remove("2,1", "M");
        expected.put("1,1", "M");
        map.Move('s');
        actual = map.getSpaces();
        assertEquals(expected, actual);
    }

    @Test
    public void moveRightTest(){
        // Should move m left 1 space
        HashMap<String, String> spaces = new HashMap<String,String>();
        spaces.put("2,4", "M");
        Grid map = new Grid(spaces, playerFace1);
        HashMap<String, String> expected = new HashMap<String,String>();
        expected.put("2,3", "M");
        expected.put("2,2",playerFace1);
        map.Move('d');
        HashMap<String, String> actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move into player and be deleted
        map.Move('d');
        actual =map.getSpaces();
        expected.remove("2,3");
        assertEquals(expected, actual);

        //should move off map and be deleted
        spaces.put("3,0", "M");
        actual = map.getSpaces();
        map.Move('d');
        assertEquals(expected, actual);

        //should move both Ms left thus player moved right 
        spaces.put("1,1", "M");
        spaces.put("3,3", "M");
        expected.put("1,0", "M");
        expected.put("3,2", "M");
        map.Move('d');
        actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms left deleting one thus player moved right 
        expected.remove("1,0", "M");
        expected.remove("3,2", "M");
        expected.put("3,1", "M");
        map.Move('d');
        actual = map.getSpaces();
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeftTest(){
        // Should move m right 1 space
        HashMap<String, String> spaces = new HashMap<String,String>();
        spaces.put("2,0", "M");
        Grid map = new Grid(spaces, playerFace1);
        HashMap<String, String> expected = new HashMap<String,String>();
        expected.put("2,1", "M");
        expected.put("2,2",playerFace1);
        map.Move('a');
        HashMap<String, String> actual = map.getSpaces();
        assertEquals(expected, actual);

        // M should move into player and be deleted
        map.Move('a');
        actual =map.getSpaces();
        expected.remove("2,1");
        assertEquals(expected, actual);

        // M should move off map and be deleted
        spaces.put("3,4", "M");
        actual = map.getSpaces();
        map.Move('a');
        assertEquals(expected, actual);
        
        //should move both Ms right thus player moved left 
        spaces.put("1,1", "M");
        spaces.put("3,3", "M");
        expected.put("1,2", "M");
        expected.put("3,4", "M");
        map.Move('a');
        actual = map.getSpaces();
        assertEquals(expected, actual);

        //should move both Ms right deleting one thus player moved left 
        expected.remove("1,2", "M");
        expected.remove("3,4", "M");
        expected.put("1,3", "M");
        map.Move('a');
        actual = map.getSpaces();
        assertEquals(expected, actual);
        
    }

    @Test
    public void TestMonsterCollision(){
        HashMap<String, String> spaces = new HashMap<String,String>();
        spaces.put("2,0", "M");
        spaces.put("3,2", "M");
        Grid map = new Grid(spaces, playerFace1);
        map.Move('s');
        assertTrue("The Monster Collided flag should have been set", map.getMonsterColisionFlag());
        assertFalse("The Monster Collided flag should have been reset to false", map.getMonsterColisionFlag());
        map.Move('s');
        assertFalse("The Monster Collided flag should not have been set to true", map.getMonsterColisionFlag());
    }
}
