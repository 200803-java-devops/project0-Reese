package reeseBenson.revature.project0.Data;

import java.util.List;

import reeseBenson.revature.project0.Monster;

public class PlayerEntity {
    private String face;
    private String name;
    private int id;
    private List<MonsterEntity> monsters;

    public PlayerEntity(String face, String name, int id, List<MonsterEntity> monsters){
        this.id = id;
        this.face = face;
        this.name = name;
        this.monsters = monsters;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getFace() {
        return face;
    }

    public List<MonsterEntity> getMonsters() {
        return monsters;
    }
    
}