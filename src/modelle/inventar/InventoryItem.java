package modelle.inventar;

public class InventoryItem {
    public int anzahl;
    public String anzeigename;
    private int gewicht;


    private static int itemCount;

    public InventoryItem(String name) {
        this.anzahl = itemCount++;
        this.anzeigename = name;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void auflisten() {
        System.out.println("Name: " + anzeigename + ", Anzahl: " + getItemCount() + ", Gewicht: " + getGewicht());
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getDisplayName() {
        return anzeigename;
    }

    public String getAnzeigename() {
        return anzeigename;
    }

    public static void setItemCount(int itemCount) {
        InventoryItem.itemCount = itemCount;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}

