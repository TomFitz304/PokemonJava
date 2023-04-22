package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Elements;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Tackle;

public class Bulbasaur extends Pokemon {

    public Bulbasaur(){
        super();
        maxHP = 45;
        hp = maxHP;
        elements.add(Elements.GRASS);
        elements.add(Elements.POISON);
        moves[0] = new Tackle();
        speed = 45;
        weaknesses.add(Elements.FLYING);
        weaknesses.add(Elements.FIRE);
        weaknesses.add(Elements.PSYCHIC);
        weaknesses.add(Elements.ICE);

        superResistances.add(Elements.GRASS);

        resistances.add(Elements.FIGHTING);
        resistances.add(Elements.WATER);
        resistances.add(Elements.ELECTRIC);
    }

}
