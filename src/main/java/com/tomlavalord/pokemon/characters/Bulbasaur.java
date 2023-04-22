package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Element;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Tackle;

import java.util.EnumSet;
import java.util.Set;

import static com.tomlavalord.pokemon.Element.*;

public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        addMove(new Tackle());
        speed = 45;
    }

    @Override
    protected Set<Element> getElements() {
        return EnumSet.of(GRASS, POISON);
    }

    @Override
    protected Set<Element> getWeaknesses() {
        return EnumSet.of(FLYING, FIRE, PSYCHIC, ICE);
    }

    @Override
    protected Set<Element> getSuperWeaknesses() {
        return EnumSet.noneOf(Element.class);
    }

    @Override
    protected Set<Element> getResistances() {
        return EnumSet.of(FLYING, FIRE, PSYCHIC, ICE);
    }

    @Override
    protected Set<Element> getSuperResistances() {
        return EnumSet.of(GRASS);
    }

    @Override
    public int getMaxHP() {
        return 45;
    }
}
