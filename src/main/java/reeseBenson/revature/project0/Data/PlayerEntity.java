package reeseBenson.revature.project0.Data;

import java.util.List;

import reeseBenson.revature.project0.Monster;

public class PlayerEntity {
    private String face;
    private String name;
    private List<Monster> monsters;

    public PlayerEntity(String face, String name, List<Monster> monsters){
        this.face = face;
        this.name = name;
        this.monsters = monsters;
    }    
    
    public String getName() {
        return name;
    }

    public String getFace() {
        return face;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
    
}