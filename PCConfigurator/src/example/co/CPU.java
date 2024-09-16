package example.co;
//realizacja cześćiej
public class CPU extends PCComponent {
    private String socket;
    private int TDP;
    public CPU(String name, double price, String description, String socket, int TDP) {
        super(name, price, description);
        this.socket = socket;
        this.TDP = TDP;

    }
    public String getSocket() {
        return socket;
    }
    public int getTDP(){
        return TDP;
    }
}
