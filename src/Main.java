import modelle.exceptions.InventoryFullException;
import modelle.inventar.InventoryItem;
import modelle.inventar.*;
import modelle.monster.Feuermonster;
import modelle.monster.Hero;
import modelle.monster.Phoenix;
import modelle.monster.Schneemonster;
import modelle.weapon.Weapon;
import modelle.world.Room;
import modelle.world.World;

public class Main {
    public static void main(String[] args) {

        Food food1 = new Food("Apfel", 3);
        Food food2 = new Food("Banane", 5);
        Food food3 = new Food("Kirsche", 10);
        Drink drink1 = new Drink("Wasser", "FRESH");
        Drink drink2 = new Drink("Wodka", "YUMMY");
        Drink drink3 = new Drink("Limo", "FRUITY");
        Weapon weapon1 = new Weapon("Schwert", 5, 20, 4);
        Weapon weapon2 = new Weapon("Pfeil", 10, 1, 10);
        Weapon weapon3 = new Weapon("Pistole", 30, 10, 40);
        Armor armor1 = new Armor("Metall", 20);
        Armor armor2 = new Armor("Holz", 6);
        Armor armor3 = new Armor("Ketten", 10);
        Hero hero = new Hero("Roy", 8, 10);
        Room room1 = new Room("room1", "Bedroom");
        Room room2 = new Room("room1", "Kitchen");
        Room room3 = new Room("room1", "Dungeon");
        World world = new World(hero);
        Feuermonster f = new Feuermonster(3);
        Schneemonster s = new Schneemonster(4);
        Phoenix p = new Phoenix(5);

        f.setMonstername("feuer");
        s.setMonstername("eis");
        p.setMonstername("phoenix");
        f.chant();
        s.chant();
        p.chant();
        f.setOnFire(s);
        s.freeze(p);
        p.resurrect(s);
        f.getTamed(hero);
        f.cuddle(4);
        hero.receiveCuddle(4);

        InventoryItem[] item = new InventoryItem[10];
        item[0] = food1;
        item[1] = drink1;
        item[2] = weapon1;
        item[3] = armor1;
        item[4] = food2;
        item[5] = food3;
        item[6] = armor2;
        item[7] = armor3;
        item[8] = weapon2;
        item[9] = weapon3;
        room2.addItem(item[0]);
        room2.addItem(item[1]);
        room2.addItem(item[2]);
        room2.addItem(item[3]);
        room1.addItem(item[4]);
        room1.addItem(item[5]);
        room1.addItem(item[6]);
        room1.addItem(item[7]);
        room3.addItem(item[8]);
        room3.addItem(item[9]);


        for (int i = 0; i < item.length; i++) {
            item[i].setGewicht(3);
            item[i].auflisten();
        }
        System.out.println("Gewicht: " + food1.getDisplayName() + ": " + food1.getGewicht());
        System.out.println("Anzahl: " + food1.getDisplayName() + ": " + food1.getItemCount());
        food1.kochen();
        weapon1.angriffswertErmitteln();
        drink1.effektErmitteln();
        armor1.verteidigungswertErmitteln();

        room1.introduceRoom();
        room2.introduceRoom();
        room3.introduceRoom();
        room1.listContent();
        room2.listContent();
        room3.listContent();
        world.setCurrentRoom(room2);
        world.start();

        Inventory inventar = new Inventory(10);
        try {
            inventar.hinzufuegen(armor1);
            inventar.hinzufuegen(armor2);
            inventar.hinzufuegen(armor3);
            inventar.hinzufuegen(food1);
            inventar.hinzufuegen(food2);
            inventar.hinzufuegen(food3);
            inventar.hinzufuegen(drink1);
            inventar.hinzufuegen(drink2);
            inventar.hinzufuegen(drink3);
            inventar.hinzufuegen(weapon1);
            inventar.hinzufuegen(weapon2);
            inventar.hinzufuegen(weapon3);
            inventar.loeschen(food1);
        } catch (InventoryFullException ife) {
            System.out.println("voll");
            //inventar.list();//?? Welches Inventar
        }


    }
}