package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Elements;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Tackle;

public class Squirtle extends Pokemon {
    public Squirtle(){
        super();
        maxHP = 44;
        hp = maxHP;
        moves[0] = new Tackle();
        speed = 43;
        elements.add(Elements.WATER);

        weaknesses.add(Elements.GRASS);
        weaknesses.add(Elements.ELECTRIC);

        resistances.add(Elements.FIRE);
        resistances.add(Elements.WATER);
        resistances.add(Elements.ICE);

    }
}
