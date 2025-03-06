package modelle.inventar;

/**
 * Klasse Drink
 */
public class Drink extends InventoryItem {
    /**Effekt */
    public String effekt;

    /**
     * Konstruktor Drink
     * @param name Name
     * @param effekt Effekt
     */
    public Drink(String name, String effekt) {
        super(name);
        this.effekt = effekt;
    }

    /**
     * Effekt ermitteln
     */
    public void effektErmitteln() {
        System.out.println("Effekt: "+effekt);
    }
}
