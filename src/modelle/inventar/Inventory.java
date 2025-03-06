package modelle.inventar;

import modelle.exceptions.InventoryFullException;
import modelle.exceptions.NotThereException;

import java.util.ArrayList;

/**
 * Ein Inventar, was als Speicher für Items dient.
 */
public class Inventory {
    /**
     * @param belegt   Variable, welche bei hinzufuegen neuer Items hochgezaehlt wird
     */
    public int belegt;
    /**
     * Liste mit Items
     */
    public ArrayList<InventoryItem> inventory;

    /**
     * Inventarkonstruktor
     */
    public Inventory(int inventorySize) {
        belegt = 0;
        inventory = new ArrayList<InventoryItem>(inventorySize);
    }

    /**
     * Hinzufuegen eines Items ins Inventar
     *
     * @param item Item welcher hinzugefuegt werden soll
     * @throws InventoryFullException
     */
    public void hinzufuegen(InventoryItem item) throws InventoryFullException {
        if (this.belegt < this.inventory.size()) {
            this.belegt++;
            this.inventory.add(item);
        } else {
            throw new InventoryFullException("Inventory voll.");
        }
    }

    public String nameAusgeben(InventoryItem item){
       return item.getDisplayName();
    }

    /**
     * Loeschen eines Items
     *
     * @param item
     */
    public void loeschen(InventoryItem item) {
        inventory.remove(item);
    }

    /**
     * Ausgabe der Inventargroeße
     *
     * @return
     */
    public int getSize() {
        return inventory.size();
    }

    /**
     * Ausgabe eines Items
     *
     * @param idx Stelle im Inventar, wo Item liegt
     * @return Item
     * @throws NotThereException Wenn nichts im Inventar, weiterwerfen
     */
    public InventoryItem getItem(int idx) throws NotThereException {
        InventoryItem item = inventory.get(idx);
        if (item != null) {
            return item;
        } else {
            throw new NotThereException();
        }
    }

    /**
     * Ausgabe der Inventargroeße als String
     *
     * @return
     */
    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + inventory +
                ", currentNumberOfItems=" + inventory.size() +
                '}';
    }

    /**
     * List the content of the Inventory with running number (starting from 0)
     */
    public void list() {
        if (belegt != 0) {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println(i + ":" + inventory.get(i).anzeigename);
            }
        } else {
            System.out.println("Nichts enthalten im Inventar!");
        }
    }

    public void inventoryAusgeben() {
        for (InventoryItem item : inventory) {
            System.out.println(item.anzeigename);
        }
    }

    /**
     * Calculates the altogehter weight of the inventory
     *
     * @return the weight of the inventory
     */
    public int getGewicht() {
        int totalWeight = 0;
        for (InventoryItem item : inventory) {
            totalWeight += item.getGewicht();
        }
        return totalWeight;
    }

    /**
     * Belegte Felder in Inventar
     *
     * @return
     */
    public int getMaxNumberOfItems() {
        return belegt;
    }
}
