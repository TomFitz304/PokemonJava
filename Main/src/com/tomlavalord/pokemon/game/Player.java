package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    Pokemon[] party;

    protected String name;

    protected ArrayList<Pokemon> computer;

    public Player(String name){
        this.name = name;
        party = new Pokemon[6];
        computer = new ArrayList<Pokemon>();
    }
    public void addPokemon(int slot, Pokemon a){
        Scanner scanner = new Scanner(System.in);
        computer.add(party[slot]);
        party[slot] = a;
        System.out.println("What would you like to name " + a.getName());
        String nickname = scanner.nextLine();
        a.setName(nickname);
    }
    public String partyToString(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i<6; i++){
            ret.append(i).append(": ").append(party[i]).append("\n");
        }
        return ret.toString();
    }
}
