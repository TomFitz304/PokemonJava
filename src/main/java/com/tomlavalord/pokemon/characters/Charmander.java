package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Element;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Scratch;

import java.util.EnumSet;
import java.util.Set;

import static com.tomlavalord.pokemon.Element.*;

public class Charmander extends Pokemon {

    public Charmander(){
        super();
        addMove(new Scratch());
        speed = 65;
    }

    @Override
    protected Set<Element> getElements() {
        return EnumSet.of(FIRE);
    }

    @Override
    protected Set<Element> getWeaknesses() {
        return EnumSet.of(ROCK, WATER, GROUND);
    }

    @Override
    protected Set<Element> getResistances() {
        return EnumSet.of(BUG, FIRE, ICE, GRASS);
    }

    @Override
    public int getMaxHP() {
        return 39;
    }


}
