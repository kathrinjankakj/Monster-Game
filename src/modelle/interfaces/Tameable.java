package modelle.interfaces;

import modelle.monster.Hero;

public interface Tameable {
    public void getTamed(Hero tamer);

    public void cuddle(int value);
}
