package modelle.weapon;

public class WeaponClose extends Weapon {
    public int treffernah;
    public WeaponClose(String name, int strength, int schaden, int reichweite, int treffernah) {
        super(name, strength, schaden, reichweite);
        this.treffernah=treffernah;
    }
}
