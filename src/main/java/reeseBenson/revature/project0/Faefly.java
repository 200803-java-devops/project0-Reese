package reeseBenson.revature.project0;

public class Faefly extends Monster{
    /**
     * Creates a new Faefly
     */
    Faefly(){
        super();
        name = "faefly";
        type = "faefly";
        art = "(\\o/)\n(/|\\)\n ";
        health = (maxHealth = 15);
        atk = 2;
        dodgeChance = 3;
        attacks.add(new Attack("Gust", 10, 1));
        attacks.add(new Attack("Fly By", 3, 3));
    }

    /**
     * Returns a new instance of a faefly
     */
    public Monster createInstance(){
        return new Faefly();
    }
}