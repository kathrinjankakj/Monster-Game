package modelle.inventar;

/**
 * Klasse Ruestung
 */
public class Armor extends InventoryItem {
    /** Schutzwert*/
    public int schutzwert;
    /** Verteidigungswert*/
    public int verteidigungswert;

    /**
     * Konstruktor Armor
     * @param name  Name
     * @param schutzwert    Schutzwert
     */
    public Armor(String name, int schutzwert) {
        super(name);
        this.schutzwert = schutzwert;
    }

    /**
     * Verteidigungswert ermitteln
     */
    public void verteidigungswertErmitteln() {
        verteidigungswert = schutzwert * 2;
        System.out.println("Verteidigungswert: "+verteidigungswert);
    }
}
