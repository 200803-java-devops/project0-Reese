package reeseBenson.revature.project0;

public class Faefly extends Monster{
    Faefly(){
        super();
        name = "faefly";
        type = "faefly";
        art = "(\\o/)\n(/|\\)";
    }

    public Monster createInstance(){
        return new Faefly();
    }
}