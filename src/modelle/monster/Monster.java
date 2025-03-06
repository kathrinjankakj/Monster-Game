package modelle.monster;

import modelle.interfaces.Tameable;

public class Monster implements Tameable {
    private int stark;
    public String monstername;

    private int score;
    private static int monsterCount;

    public Hero tamer;

    public Monster(int stark) {
        this.stark = stark;
        this.score = 0;
        monsterCount++;
    }


    public void fight(Monster foe) {
        if (foe.stark < this.stark) {
            System.out.println("You won, you're strounger!");
            this.score++;
        } else {
            System.out.println("You lost, you're weaker!");
            foe.score++;
        }
    }

    public String getMonstername() {
        return monstername;
    }

    public String setMonstername(String monstername) {
        return this.monstername = monstername;
    }

    public void chant() {
    }


    public void getTamed(Hero tamer) {
        if (this.stark < tamer.strength) {
            System.out.println("Monster wurde gezähmt");
            this.tamer = tamer;
        } else {
            System.out.println("Monster war stärker");
        }
    }


    public void cuddle(int value) {
        if (tamer !=null) {
            tamer.receiveCuddle(value);
        } else {
            System.out.println("kein Tamer gesetzt");
        }
    }
}
