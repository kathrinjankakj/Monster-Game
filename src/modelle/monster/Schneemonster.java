package modelle.monster;

public class Schneemonster extends Monster{


    public Schneemonster(int stark) {
        super(stark);
    }


    public void freeze(Monster foe){
        System.out.println(foe.getMonstername()+ " ist eingefroren");
    }

    @Override
    public void chant(){
        System.out.println("Ich heiße "+getMonstername()+ " und ich singe...it's freezing");
    }
}
