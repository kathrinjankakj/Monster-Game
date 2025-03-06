package modelle.world;
import modelle.inventar.InventoryItem;
import modelle.exceptions.NotThereException;

import java.util.ArrayList;

/**
 * Class Room with content and descriptions
 * Adjacent rooms that can be reached must be set manually with care, no checks are perfored
 */
public class Room {

    /**
     * list of items in room
     */
    private ArrayList<InventoryItem> items;
    /**
     * list of adjacent rooms
     */
    private ArrayList<Room> adjacentRoom;
    /**
     * name of the room
     */
    private String name;
    /**
     * short description of the room
     */
    private String description;

    /**
     * Constructor
     *
     * @param name        the name of the room
     * @param description a short description
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<InventoryItem>();
        this.adjacentRoom = new ArrayList<Room>();
    }

    /**
     * set an adjacent room. Room layout can not be changed any more, so
     * there is no remove for this function
     *
     * @param room the room to be added
     */
    public void addAdjacentRoom(Room room) {
        adjacentRoom.add(room);
    }

    /**
     * Add an item to the room
     *
     * @param item the item to be added
     */
    public void addItem(InventoryItem item) {
        items.add(item);
    }

    /**
     * Remove an item from the room
     *
     * @param item the item to be removed
     */
    public void removeItem(InventoryItem item) {
        items.remove(item);
    }

    /**
     * Display the room name an the short description of the room
     */
    public void introduceRoom() {
        System.out.println("Das ist " + name);
        System.out.println(description);
    }

    /**
     * List all Item in the room, i.e. list the Items that are in the room
     */
    public void listContent() {
        System.out.println("Im Raum"+name+" befindet sich: ");

        if (items.size() == 0) {
            System.out.println("nichts.");
        } else {
            for (int i = 0; i < items.size(); ++i) {
                System.out.println(i + ":" + items.get(i).getDisplayName());
            }
        }
    }

    /**
     * List all adjacent rooms (with running number starting at 0)
     */
    public void listAdjacentRooms() {
        for (int i = 0; i < adjacentRoom.size(); i++) {
            System.out.println(i + ": " + adjacentRoom.get(i).getName());
        }
    }

    /**
     * get a reference to a room with a specified index
     *
     * @param index the index of the room to be returned
     * @return the room with the specified index
     * @throws NotThereException
     */
    public Room getAdjacentRoom(int index) throws NotThereException {
        Room room = adjacentRoom.get(index);
        if (room != null) return room;
        else throw new NotThereException();
    }

    /**
     * return an item from the inventory with a specified index
     *
     * @param index the index of the item to be returend
     * @return the item to be returned
     * @throws NotThereException
     */
    public InventoryItem getItem(int index) throws NotThereException {
        InventoryItem returnItem = items.get(index);
        if (returnItem != null) return returnItem;
        else throw new NotThereException();
    }

    /**
     * Returns the number of items in the room
     *
     * @return
     */
    public int getNumberOfItemsInRoom() {
        return items.size();
    }

    public String getName() {
        return name;
    }

}

