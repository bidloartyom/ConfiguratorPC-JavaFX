package example.co;
//realizacja cześćiej
public class GPU extends PCComponent{
    private int TDP;
    public GPU(String name, double price, String description, int TDP) {
        super(name, price, description);
        this.TDP = TDP;

    }
    public int getTDP(){
        return TDP;
    }
}

