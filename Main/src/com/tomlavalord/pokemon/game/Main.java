package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Elements;
import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.characters.Bulbasaur;
import com.tomlavalord.pokemon.characters.Charmander;
import com.tomlavalord.pokemon.characters.Squirtle;
import com.tomlavalord.pokemon.moves.VineWhip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("Enter your name");
        Player user = new Player(scanner.nextLine());
        Pokemon rivalPokemon;

        System.out.println("Choose your starter\n0: Bulbasaur\n1: Charmander\n2: Squirtle");
        for(x = scanner.nextInt(); !(x>-1 && x<3);x = scanner.nextInt()){
            System.out.println("Invalid input");
        }
        if(x == 0) {
            user.addPokemon(0, new Bulbasaur());
            rivalPokemon = new Charmander();
        }
        else if (x == 1){
            user.addPokemon(0, new Charmander());
            rivalPokemon = new Squirtle();
        }
        else {
            user.addPokemon(0, new Squirtle());
            rivalPokemon = new Bulbasaur();
        }

        OneOnOne oneOnOne = new OneOnOne(user, rivalPokemon);

        oneOnOne.battle();


    }
}