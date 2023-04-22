package com.tomlavalord.pokemon.moves;

import com.tomlavalord.pokemon.Elements;

public class Move {

    protected int power;

    protected Enum<Elements> type;

    protected int accuracy;

    protected int pp;

    public String name;

    public Move() {
        name = getClass().getSimpleName();
    }

    public int getPower() {
        return power;
    }

    public Enum<Elements> getType() {
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
