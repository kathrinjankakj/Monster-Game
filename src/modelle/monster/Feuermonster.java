package modelle.monster;

public class Feuermonster extends Monster{
    public Feuermonster(int stark) {
        super(stark);
    }

   public void setOnFire(Monster foe){
       System.out.println(foe.getMonstername()+ " brennt jetzt.");
   }
    @Override
    public void chant(){
        System.out.println("Ich heiße "+getMonstername()+ " und ich singe...it's burning");
    }
}
