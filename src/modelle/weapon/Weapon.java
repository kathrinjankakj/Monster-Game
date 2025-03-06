
package modelle.weapon;
import modelle.inventar.InventoryItem;

public class Weapon extends InventoryItem {
    public int strength;
    public int schaden;
    public int reichweite;

    public int angriffswert;

    public Weapon(String name, int strength, int schaden, int reichweite) {
        super(name);
        this.strength = strength;
        this.schaden = schaden;
        this.reichweite = reichweite;
    }

    public void angriffswertErmitteln() {
        angriffswert = (strength + reichweite) - schaden;
        System.out.println("Angriffswert: "+angriffswert);
    }
}
