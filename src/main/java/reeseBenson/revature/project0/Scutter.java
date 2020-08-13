package reeseBenson.revature.project0;

public class  Scutter extends Monster {
    Scutter(){
        super();
        name="Scutter";
        type="Scutter";
        art="\\(~)/\n-( )-\n/(_)\\";
        health = (maxHealth = 30);
        atk = 5;
        dodgeChance = 1;
        attacks.add(new Attack("Pinchers", 6, 3));
        attacks.add(new Attack("Scutter Around", 0, 5));
    }

    public Monster createInstance(){
        return new Scutter();
    }
}