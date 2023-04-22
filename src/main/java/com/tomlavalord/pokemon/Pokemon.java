package com.tomlavalord.pokemon;

import com.tomlavalord.pokemon.moves.Move;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public abstract class Pokemon {

    final int HP_BAR_LENGTH = 10;
    protected String name;
    protected int hp;
    protected final Set<Element> elements;
    protected final Set<Element> weaknesses;
    protected final Set<Element> superWeaknesses;
    protected final Set<Element> resistances;
    protected final Set<Element> superResistances;

    protected final List<Move> moves;
    protected int speed;

    protected Pokemon() {
        name = getClass().getSimpleName();

        this.elements = getElements();
        this.weaknesses = getWeaknesses();
        this.superWeaknesses = getSuperWeaknesses();
        this.resistances = getResistances();
        this.superResistances = getSuperResistances();

        hp = getMaxHP();
        moves = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    private double multiplier(Move a){
        Element c = a.getType();
        if (weaknesses.contains(c)) {
            return 2;
        }
        else if (superWeaknesses.contains(c)) {
            return 4;
        }
        else if (resistances.contains(c)) {
            return 2;
        }
        else if (superResistances.contains(c)) {
            return 2;
        }
        return 1;
    }

    protected abstract Set<Element> getElements();
    protected abstract Set<Element> getWeaknesses();

    protected Set<Element> getSuperWeaknesses() {
        return EnumSet.noneOf(Element.class);
    }

    protected abstract Set<Element> getResistances();

    protected Set<Element> getSuperResistances() {
        return EnumSet.noneOf(Element.class);
    }

    protected void addMove(Move m) {
        moves.add(m);
    }

    public void receiveAttack(Move move){
        int dmg = (int)(move.getPower() * multiplier(move));
        hp -= dmg;
        if (hp < 0)
            hp = 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public String movesToString() {
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < moves.size();i++){
            ret.append(i).append(": ").append(moves.get(i));
        }
        return ret.toString();
    }

    public int getSpeed() {
        return speed;
    }

    public abstract int getMaxHP();

    public String toString(){
        StringBuilder hpBar = new StringBuilder();
        for(double i = 0;i<HP_BAR_LENGTH;i++){
            hpBar.append(i < (((double)hp/getMaxHP())*HP_BAR_LENGTH) ? "*" : "-");
        }
        StringBuilder icons = new StringBuilder();
        for (Element a : elements)
            icons.append(a.iconToString());
        return name + icons + "\n[" + hpBar + "]" + hp + "/" + getMaxHP();
    }
}
