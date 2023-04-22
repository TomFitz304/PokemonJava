package com.tomlavalord.pokemon.moves;

import com.tomlavalord.pokemon.Element;

public class Move {

    protected int power;

    protected Element type;

    protected int accuracy;

    protected int pp;

    public String name;

    public Move() {
        name = getClass().getSimpleName();
    }

    public int getPower() {
        return power;
    }

    public Element getType() {
        return type;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPp() {
        return pp;
    }
    public String toString(){
        return name;
    }
}
