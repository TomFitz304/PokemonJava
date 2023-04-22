package com.tomlavalord.pokemon.characters;

import com.tomlavalord.pokemon.Element;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Tackle;

import java.util.EnumSet;
import java.util.Set;

public class Squirtle extends Pokemon {

    public Squirtle() {
        super();
        addMove(new Tackle());
        speed = 43;
    }

    @Override
    protected Set<Element> getElements() {
        return EnumSet.of(Element.WATER);
    }

    @Override
    protected Set<Element> getWeaknesses() {
        return EnumSet.of(Element.GRASS, Element.ELECTRIC);
    }

    @Override
    protected Set<Element> getResistances() {
        return EnumSet.of(Element.FIRE, Element.WATER, Element.ICE);
    }

    @Override
    public int getMaxHP() {
        return 44;
    }
}
