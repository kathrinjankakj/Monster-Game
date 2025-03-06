
package modelle.monster;
import modelle.exceptions.InventoryFullException;
import modelle.interfaces.Tamer;
import modelle.inventar.InventoryItem;
import modelle.exceptions.NotThereException;
import modelle.exceptions.TooWeakException;
import modelle.inventar.Inventory;

public class Hero implements Tamer {

    /**
     * Name of the Hero
     */
    protected String name;
    /**
     * Strength of the Hero (i.e. how much he can carry)
     */
    protected double strength;
    /**
     * The inventory, where all kind of stuff can be stored
     */
    private Inventory inventory;

    public int maxhealth;

    /**
     * Held constructor
     *
     * @param name          name of the hero
     * @param strength      how much he can carry
     * @param inventorySize how many items he can store in the inventory
     */
    public Hero(String name, double strength, int inventorySize) {
        this.name = name;
        this.strength = strength;
        inventory = new Inventory(inventorySize);
         maxhealth=20;
    }

    /**
     * Add an item to the Inventory
     *
     * @param item the item to be added
     * @throws InventoryFullException
     * @throws TooWeakException
     */
    public void addInventoryItem(InventoryItem item) throws InventoryFullException, TooWeakException {
        if (inventory.getGewicht() + item.getGewicht() < strength) {
            inventory.hinzufuegen(item);
        } else {
            throw new TooWeakException();
        }
    }

    /**
     * Returns the number of items to be returned
     *
     * @return the number of items in the inventory
     */
    public int getNumberOfItemsInInventory() {
        return inventory.getSize();
    }

    /**
     * list the things in the inventory (with nice intro)
     */
    public void listInventoryContent() {
        System.out.println("Akutell im Inventar: ");
        inventory.list();
    }

    /**
     * get an InventoryItem with a specific index form the inventory
     *
     * @param idx the index
     * @return the item at the specified position
     * @throws NotThereException
     */
    public InventoryItem getInventoryItem(int idx) throws NotThereException {
        return inventory.getItem(idx);
    }

    /**
     * Removes the item from the inventory
     *
     * @param item the item to be removed
     */
    public void removeInventoryItem(InventoryItem item) {
        inventory.loeschen(item);
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public double getStrength() {
        return strength;
    }

    public void receiveCuddle(int value){
       if(strength<maxhealth){
           strength+=value;
       } else {
           System.out.println("Maxhealth errreicht.");
       }
        System.out.println(strength);
    }
}

