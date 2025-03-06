package modelle.monster;

public class Phoenix extends Monster {
    public Phoenix(int stark) {
        super(stark);
    }

    public void resurrect(Monster foe) {
        System.out.println(foe.getMonstername()+ " lebt jetzt wieder");
    }
    @Override
    public void chant() {
        System.out.println("Ich heiße " + getMonstername() + " und ich singe...it's flying");
    }

}
