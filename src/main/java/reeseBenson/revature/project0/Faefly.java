package reeseBenson.revature.project0;

public class Faefly extends Monster{
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

    public Monster createInstance(){
        return new Faefly();
    }
}