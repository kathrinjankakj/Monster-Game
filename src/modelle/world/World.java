package modelle.world;

import modelle.exceptions.InventoryFullException;
import modelle.exceptions.NotThereException;
import modelle.exceptions.TooWeakException;
import modelle.monster.Hero;

import java.util.Scanner;

/**
 * A World with rooms, items and a hero (later on, more can be added)
 */
public class World {

    /**
     * Our hero that visits the world
     */
    Hero hero;

    /**
     * the current room the hero is in
     */
    private Room currentRoom;

    /**
     * to fetch keyboard input
     */
    Scanner inputFetcher;

    /**
     * Constructs a word for a hero
     *
     * @param hero the hero that walks around in this world
     */
    public World(Hero hero) {
        this.hero = hero;
        this.inputFetcher = new Scanner(System.in);
    }

    /**
     * Set a room as current room, where actions take place
     *
     * @param r
     */
    public void setCurrentRoom(Room r) {
        currentRoom = r;
    }

    /**
     * Print help for keyboard input
     */
    public void printHelp() {
        System.out.println("u:            Umsehen");
        System.out.println("a:            Gegenstand aufheben");
        System.out.println("i:            Inventar ausgeben");
        System.out.println("l:            Gegenstand ablegen");
        System.out.println("g:            In nächsten Raum gehen.");
    }

    /**
     * Start the text adventure => infinite loop that processes keyboard input and
     * performs actions accordingly
     */
    public void start() {

        while (true) {

            System.out.println("Was möchtest du als nächstes tun (Enter für Hilfe)? ");
            String input = inputFetcher.nextLine();

            if (input.equals("u")) {
                currentRoom.introduceRoom();
                currentRoom.listContent();
            } else if (input.equals("a")) {
              //  take();
            } else if (input.equals("i")) {
                hero.listInventoryContent();
            } else if (input.equals("l")) {
            //    put();//??throws...
            } else if (input.equals("g")) {
               //  moveToNextRoom();//?
            } else {
                System.out.println("Ich verstehe dich nicht. Probiere es nochmal.");
                printHelp();
            }
            System.out.println();
        }
    }

    /**
     * go to a new room
     * - first, the user gets asked where to go
     * - a list with all rooms, that can be reached should be listed
     * - input with the number of the room that should be reached should be fetched
     * - fetch the room and go to it (currentRoom = the fetched room),
     * - error handling if invalid input
     */
    public void moveToNextRoom() throws NotThereException {
        System.out.println("In welchen Raum möchtest du gehen?");
        int input = inputFetcher.nextInt();
        currentRoom = currentRoom.getAdjacentRoom(input);
        System.out.println();
    }

    /**
     * pick an item
     * - Ask the user which items are in the room (with running number starting at 0)
     * - getInput, with this input fetch item
     * - this item should be put in the hero's inventory if possible (and removed from the room)
     * - error hanling, if something is wrong
     */
    public void take() throws InventoryFullException, TooWeakException, NotThereException {
        System.out.println("Welches Item soll genommen werden?");
        int input = inputFetcher.nextInt();
        try {
            hero.addInventoryItem(currentRoom.getItem(input));
        } catch (InventoryFullException e) {
            throw new InventoryFullException();
            // System.out.println("ich bin voll!");
        } catch (TooWeakException e) {
            throw new TooWeakException();
            // System.out.println("ich bin zu schwach");
        } catch (NotThereException e) {
            throw new NotThereException();
            // System.out.println("das item " + input + " existiert nicht");
        }
        System.out.println();
    }

    /**
     * remove an item
     * - list which items are in the inventory (with running number beginning from 0)
     * - fetch input which item to remove
     * - remove this item
     */
    public void put() throws NotThereException {
        System.out.println("Welches Item soll abgelegt werden?");
        int input = inputFetcher.nextInt();
        currentRoom.removeItem(hero.getInventoryItem(input));
        System.out.println();
    }
}
