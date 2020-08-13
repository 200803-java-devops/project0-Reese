package reeseBenson.revature.project0.GameComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Grid {
    int innerWidth;
    int innerHieght;
    int height;
    int width;
    String character;
    String characterKey;
    String prettyPrint;
    HashMap<String, String> spaces;
    boolean MonsterCollision;

    public Grid(String character) {
        innerHieght = 3;
        innerWidth = 7;
        height = 5;
        width = 5;
        this.character = character;
        characterKey = "2,2";
        spaces = new HashMap<String, String>();
        spaces.put("2,2", character);
        prettyPrint = "";
        MonsterCollision = false;
        buildPrettyPrint();
    }

    public Grid(HashMap<String, String> spaces, String character) {
        innerHieght = 3;
        innerWidth = 7;
        height = 5;
        width = 5;
        this.character = character;
        characterKey = "2,2";
        this.spaces = spaces;
        spaces.put("2,2", character);
        prettyPrint = "";
        MonsterCollision = false;
        buildPrettyPrint();
    }

    private void buildPrettyPrint() {
        prettyPrint ="";
        for (int i = 0; i < height; i++) {
            prettyPrint += buildRow(i);
        }
    }

    private String buildRow(int rowNumber) {
        String horizontalEdge = buildHorizontal(' ', '-') + "\n";
        String horizontalSpacer = buildHorizontal('|', ' ') + "\n";
        String result = horizontalEdge;

        for (int i = 0; i < innerHieght; i++) {
            if (i == Math.floorDiv(innerHieght, 2)) {
                result += buildItemRow(rowNumber) + "\n";
            } else {
                result += horizontalSpacer;
            }
        }
        return result;
    }

    private String buildHorizontal(char edge, char center) {
        String result = "";
        for (int i = 0; i < width; i++) {
            result += edge;
            for (int j = 0; j < innerWidth; j++)
                result += center;
            result += edge;
        }
        return result;
    }

    private String buildItemRow(int row) {
        String result = "";
        for (int i = 0; i < width; i++) {
            result += "|";
            String key = row + "," + i;
            String item = spaces.get(key);
            for (int j = 0; j < innerWidth; j++) {
                if (item != null && Math.floorDiv((innerWidth - item.length()), 2) == j) {
                    result += item;
                    j += item.length() - 1;
                } else {
                    result += " ";
                }
            }
            result += "|";
        }
        return result;
    }

    public void Move(char direction) {
        Object[] keys = spaces.keySet().toArray();
        ArrayList<int[]> coords = new ArrayList<int[]>();
        ArrayList<String> values = new ArrayList<>();
        for (Object key : keys) {
            if (key != characterKey) {
                values.add(spaces.get(key));
                int[] intKeys = getCoordsFromKey((String) key);
                coords.add(intKeys);
                spaces.remove(key);
            }
        }
        switch (direction) {
            case 'w':
                moveUp(coords, values);
                break;
            case 's':
                moveDown(coords, values);
                break;
            case 'a':
                moveLeft(coords, values);
                break;
            case 'd':
                moveRight(coords, values);
                break;
        }
        buildPrettyPrint();
    }

    private void moveLeft(ArrayList<int[]> coords, ArrayList<String> values) {
        for (int i = 0; i < coords.size(); i++) {
            int[] x = coords.get(i);
            x[1] += 1;
            if(removeInvalidCoords(x, i, coords, values)){
                i--;
            };
        }
        addItemsToSpaces(coords, values);
    }

    private void moveRight(ArrayList<int[]> coords, ArrayList<String> values) {
        for (int i = 0; i < coords.size(); i++) {
            int[] x = coords.get(i);
            x[1] -= 1;
            if(removeInvalidCoords(x, i, coords, values)){
                i--;
            };
        }
        addItemsToSpaces(coords, values);
    }
    
    private void moveDown(ArrayList<int[]> coords, ArrayList<String> values) {
        for (int i = 0; i < coords.size(); i++) {
            int[] x = coords.get(i);
            x[0] -= 1;
            if(removeInvalidCoords(x, i, coords, values)){
                i--;
            }    
        }
        addItemsToSpaces(coords, values);
    }

    private void moveUp(ArrayList<int[]> coords, ArrayList<String> values) {
        for (int i = 0; i < coords.size(); i++) {
            int[] x = coords.get(i);
            x[0] += 1;
            if(removeInvalidCoords(x, i, coords, values)){
                i--;
            };
        }
        addItemsToSpaces(coords, values);
    }

    private boolean validCoords(int[] key) {
        return key[0] >= 0 && key[0] < height && key[1] >= 0 && key[1] < width;
    }

    private String getKeyString(int[] key) {
        return key[0] + "," + key[1];
    }

    private boolean removeInvalidCoords(int[] key, int index, ArrayList<int[]> coords, ArrayList<String> values) {
        String x = getKeyString(key);
        if (x.equals(characterKey)){
            MonsterCollision = true;
            coords.remove(key);
            values.remove(index);
            return true;
        }
        if (!validCoords(key)) {
            coords.remove(key);
            values.remove(index);
            return true;
        }
        return false;
    }

    private void addItemsToSpaces(ArrayList<int[]> coords, ArrayList<String> values) {
        for (int i = 0; i < coords.size(); i++) {
            int[] key = coords.get(i);
            spaces.put(key[0] + "," + key[1], values.get(i));
        }
    }

    private int[] getCoordsFromKey(String key) {
        String[] splitKey = key.split(",");
        int[] coords = { Integer.parseInt(splitKey[0]), Integer.parseInt(splitKey[1]) };
        return coords;
    }
    
    public void addMonster(){
        Random r = new Random();
        int row = r.nextInt(height);
        int col = r.nextInt(width);
        String key = row + "," + col;
        if(!key.equals(characterKey)){
            spaces.put(key, "M");
        }
    }

    public HashMap<String, String> getSpaces() {
        return spaces;
    }

    public String getPrettyPrint() {
        return prettyPrint;
    }

    /**
     * This is a function that checks if a monster has collided with the player
     * @return true if the player has collided with a monster false otherwise
     * @version 1.0.0 8/10/2020
     * @author Reese Benson
     */
    public Boolean getMonsterColisionFlag(){
        if(MonsterCollision){
            MonsterCollision = false;
            return true;
        }
        return false;
    }

    /**
     * The getter function for the grid width.
     * @return The width of the grid
     */
    public int getWidth(){
        return width;
    }
    /**
     * The Getter function for grid height
     * @return The hieght of the grid
     */
    public int getHeight(){
        return height;
    }

    
}