package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Elements;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Scratch;

public class Charmander extends Pokemon {
    public Charmander(){
        super();
        maxHP = 39;
        hp = maxHP;
        moves[0] = new Scratch();
        speed = 65;
        elements.add(Elements.FIRE);

        weaknesses.add(Elements.ROCK);
        weaknesses.add(Elements.WATER);
        weaknesses.add(Elements.GROUND);

        resistances.add(Elements.BUG);
        resistances.add(Elements.FIRE);
        resistances.add(Elements.ICE);
        resistances.add(Elements.GRASS);

    }


}
