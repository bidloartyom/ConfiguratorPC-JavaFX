package example.co;
//realizacja cześćiej
public class Motherboard extends PCComponent {
    private String socket;
    public Motherboard(String name, double price, String description, String socket) {
        super(name, price, description);
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
}
