package modelle.inventar;

public class Food extends InventoryItem {
    public int naehrwert;

    public Food(String name, int naehrwert) {
        super(name);
        this.naehrwert = naehrwert;
    }

    public void kochen() {
        System.out.println("Nährwert: "+naehrwert);
    }

}
