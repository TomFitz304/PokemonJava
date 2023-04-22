package com.tomlavalord.pokemon;

import com.tomlavalord.pokemon.moves.Move;
import com.tomlavalord.pokemon.moves.NothingMove;

import java.util.EnumSet;

public class Pokemon {

    final int HP_BAR_LENGTH = 10;
    protected String name;
    protected int hp;
    protected int maxHP;
    protected EnumSet<Elements> elements;
    protected EnumSet<Elements> weaknesses;
    protected EnumSet<Elements> superWeaknesses;
    protected EnumSet<Elements> resistances;
    protected EnumSet<Elements> superResistances;

    protected Move[] moves;
    protected int speed;

    public void setName(String name) {
        this.name = name;
    }

    private double multiplier(Move a){
        Enum<Elements> c = a.getType();
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

    public Pokemon(){
        moves = new Move[4];
        for (int i = 0; i < 4; i++){
            moves[i] = new NothingMove();
        }
        elements = EnumSet.noneOf(Elements.class);
        resistances = EnumSet.noneOf(Elements.class);
        superResistances = EnumSet.noneOf(Elements.class);
        weaknesses = EnumSet.noneOf(Elements.class);
        superWeaknesses = EnumSet.noneOf(Elements.class);
        name = getClass().getSimpleName();
    }
    public String toString(){
        StringBuilder hpBar = new StringBuilder();
        for(double i = 0;i<HP_BAR_LENGTH;i++){
            hpBar.append(i < (((double)hp/maxHP)*HP_BAR_LENGTH) ? "*" : "-");
        }
        StringBuilder icons = new StringBuilder();
        for (Elements a : elements)
            icons.append(a.iconToString());
        return name + icons + "\n[" + hpBar + "]" + hp + "/" + maxHP;
    }
    public void receiveAttack(Move move){
        int dmg = (int)(move.getPower() * multiplier(move));
        hp -= dmg;
        if (hp < 0)
            hp = 0;

    }
    public void learnMove(Move a, int slot){
        moves[slot] = a;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }


    public Move[] getMoves() {
        return moves;
    }
    public String movesToString(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i<4;i++){
            ret.append(i).append(": ").append(moves[i]).append("\n");
        }
        return ret.toString();
    }
    public int getSpeed() {
        return speed;
    }
    public int getHP_BAR_LENGTH() {
        return HP_BAR_LENGTH;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public EnumSet<Elements> getElements() {
        return elements;
    }
}
