package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.characters.Bulbasaur;
import com.tomlavalord.pokemon.characters.Charmander;
import com.tomlavalord.pokemon.characters.Squirtle;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Class<? extends Pokemon>> playablePokemon = List.of(Bulbasaur.class,
                                                                                  Charmander.class,
                                                                                  Squirtle.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        Player user = new Player(scanner.nextLine());

        System.out.println("Choose your starter");
        for (int i = 0; i < playablePokemon.size(); i++) {
            System.out.println(i + ": " + playablePokemon.get(i).getSimpleName());
        }

        int x;
        for(x = scanner.nextInt(); !(x > -1 && x < playablePokemon.size());x = scanner.nextInt()){
            System.out.println("Invalid input");
        }
        scanner.nextLine(); // consume newline

        Pokemon pokemon = createPokemon(playablePokemon.get(x));

        System.out.println("What would you like to name " + pokemon.getName());
        user.addPokemon(pokemon, scanner.nextLine());

        Class<? extends Pokemon> randomOpponent = playablePokemon.get((int)(Math.random() * playablePokemon.size()));
        OneOnOne oneOnOne = new OneOnOne(user, createPokemon(randomOpponent), scanner);

        oneOnOne.battle();
    }

    public static Pokemon createPokemon(Class<? extends Pokemon> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}