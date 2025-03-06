package modelle.weapon;

public class WeaponDistant extends Weapon {
    public int trefferfern;
    public WeaponDistant(String name, int strength, int schaden, int reichweite, int trefferfern) {
        super(name, strength, schaden, reichweite);
        this.trefferfern=trefferfern;
    }
}
