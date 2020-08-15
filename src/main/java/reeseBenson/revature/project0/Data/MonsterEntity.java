package reeseBenson.revature.project0.Data;

import reeseBenson.revature.project0.Monster;

public class MonsterEntity {
    private int monsterId;
    private int playerId;
    private String name;
    private String type;
    private int atk;
    private int dodge;

    public MonsterEntity(Monster m, int playerId){
        this.playerId = playerId;
        this.name = m.getName();
        this.type = m.getType();
        this.atk = m.getAtk();
        this.dodge = m.getDodgeChance();
        this.monsterId = 0;
    }

    public MonsterEntity(int playerId, String name, String type, int atk, int dodgeChance, int monsterId){
        this.playerId = playerId;
        this.name = name;
        this.type = type;
        this.atk = atk;
        this.dodge = dodgeChance;
        this.monsterId = monsterId;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public int getAtk() {
        return atk;
    }

    public int getDodge() {
        return dodge;
    }

    public String getName() {
        return name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getType() {
        return type;
    }

    
}