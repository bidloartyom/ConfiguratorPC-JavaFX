package example.co;

public class PSU extends PCComponent {
    private int power;

    public PSU(String name, double price, String description, int power) {
        // Wywołujemy konstruktor klasy nadrzędnej, przekazując stałą wartość TDP
        super(name, price, description);
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
