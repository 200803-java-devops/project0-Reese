package reeseBenson.revature.project0;

public class  Scutter extends Monster {
    Scutter(){
        super();
        name="Scutter";
        type="Scutter";
        art="\\(~)/\n-( )-\n/(_)\\";
    }

    public Monster createInstance(){
        return new Scutter();
    }
}