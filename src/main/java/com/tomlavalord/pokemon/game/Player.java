package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private final List<Pokemon> party;

    protected String name;

    protected ArrayList<Pokemon> computer;

    public Player(String name){
        this.name = name;
        party = new ArrayList<>();
        computer = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon, String nickName){
        pokemon.setName(nickName);
        party.add(pokemon);
    }

    public Pokemon choosePokemon(Scanner scanner) {
        System.out.println("Choose a Pokemon");
        System.out.println(partyToString());
        return party.get(Math.min(Math.abs(scanner.nextInt()), party.size()));
    }

    public String partyToString(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < party.size(); i++){
            ret.append(i).append(": ").append(party.get(i));
        }
        return ret.toString();
    }
}
