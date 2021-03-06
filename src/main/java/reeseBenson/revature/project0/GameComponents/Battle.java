package reeseBenson.revature.project0.GameComponents;

import java.util.concurrent.TimeUnit;

import reeseBenson.revature.project0.MyIO;
import reeseBenson.revature.project0.Actors.Actor;
import reeseBenson.revature.project0.Monsters.Monster;
import reeseBenson.revature.project0.Monsters.Attacks.Attack;

public class Battle {
    Monster playerMonster;
    Monster enemyMonster;
    Actor enemy;
    Actor player;
    MyIO io;

    /**
     * Creates a new Battle object.
     * @param player THe Actor that will act first
     * @param enemy The actor that will act Second
     * @param io The battles primary output and input stream handler
     */
    public Battle(Actor player, Actor enemy, MyIO io) {
        this.player = player;
        this.enemy = enemy;
        this.io = io;
        playerMonster = player.selectMonster();
        enemyMonster = enemy.selectMonster();
    }

    /**
     * Starts a new battle, by printing to the output Stream and accepting play inputs.
     * Reports the winner of the battle when the oposing players monster reaches 0 hit points.
     */
    public void Start() {
        while (true) {
            printStage();
            attack(player, enemy);
            if (!enemyMonster.isAlive()){
                io.write(player.getName() + " has won!");
                resetMonsters();
                break;
            }
            printStage();
            attack(enemy, player);
            if (!playerMonster.isAlive()){
                io.write(enemy.getName() + " has won!");
                resetMonsters();
                break;
            }
        }
    }

    private void resetMonsters(){
        playerMonster.refresh();
        enemyMonster.refresh();
    }

    private void printStage() {
        String[] myArt = playerMonster.getArt().split("\n");
        String[] enemyArt = enemyMonster.getArt().split("\n");
        enemyMonster.getArt().split("\n");
        io.write(player.getFace() + "\t\t\t\t\t\t" + enemy.getFace());
        io.write("_____\t\t\t\t\t\t_____");
        io.write("|   |\t\t\t\t\t\t|   |");
        io.write("|   |\t\t\t\t\t\t|   |");
        io.write("|   |\t" + myArt[0] + "\t\t\t\t" + enemyArt[0] + "\t|   |");
        io.write("|   |\t" + myArt[1] + "\t\t\t\t" + enemyArt[1] + "\t|   |");
        io.write("|   |\t" + myArt[2] + "\t\t\t\t" + enemyArt[2] + "\t|   |");
        io.write("-----------------------------------------------------");
        io.write("Hp: " + playerMonster.getHealth() + "/" + playerMonster.getMaxHealth() + "\t\t\t\t\t\t" + "Hp: "
                + enemyMonster.getHealth() + "/" + enemyMonster.getMaxHealth());
    }

    private void attack(Actor attacker, Actor deffender){
        Attack choosenAttack = attacker.selectAttack();
        io.write(attacker.getCurrentMonster().getName() + " uses..." + choosenAttack.getName());
        String msg = choosenAttack.perform(deffender.getCurrentMonster(), attacker.getCurrentMonster().getAtk()) ? " hits!" : " misses!";
        io.write(choosenAttack.getName() + msg);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}