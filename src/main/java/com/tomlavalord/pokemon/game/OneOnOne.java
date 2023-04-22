package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Move;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OneOnOne {

    protected Pokemon playersPokemon;
    protected Pokemon computerPokemon;

    private final Scanner scanner;

    private enum MoveStatus {
        MISS,FAINT,HIT
    }

    private enum TurnStatus {
        COMPUTERFAINT, NOFAINT, PLAYERFAINT
    }

    public OneOnOne(Player player, Pokemon enemy, Scanner scanner) {
        this.scanner = scanner;
        this.playersPokemon = player.choosePokemon(scanner);
        this.computerPokemon = enemy;
    }

    private boolean atkLands(Move move) {
        return ((int)(Math.random()*100+1) < move.getAccuracy() +1);
    }

    public TurnStatus doTurn() {
        List<Move> computerMoves = computerPokemon.getMoves();
        Move computerMove = computerMoves.get((int) (Math.random() * computerMoves.size()));
        System.out.println("Choose a move");
        System.out.println(playersPokemon.movesToString());
        int numPlayerMove = scanner.nextInt();
        int isEqual = (playersPokemon.getSpeed() == computerPokemon.getSpeed() ? (int)(Math.random()*10+1) : 0);
        if (playersPokemon.getSpeed() < computerPokemon.getSpeed() || isEqual > 5){
            if (makeMove(playersPokemon, computerPokemon, computerMove) == MoveStatus.FAINT){
                return TurnStatus.PLAYERFAINT;
            }
            else if (makeMove(computerPokemon, playersPokemon, playersPokemon.getMoves().get(numPlayerMove)) == MoveStatus.FAINT){
                return TurnStatus.COMPUTERFAINT;
            }
        }
        else  {
            if (makeMove(computerPokemon, playersPokemon, playersPokemon.getMoves().get(numPlayerMove)) == MoveStatus.FAINT){
                return TurnStatus.COMPUTERFAINT;
            }
            else if (makeMove(playersPokemon, computerPokemon, computerMove) == MoveStatus.FAINT){
                return TurnStatus.PLAYERFAINT;
            }
        }
        return TurnStatus.NOFAINT;
    }

    public void battle(){
        int turn = 1;

        do{
            System.out.println();
            System.out.println("Turn " + turn);
            System.out.println(playersPokemon + "\n" + computerPokemon);
            System.out.println();
            turn++;
        }while(doTurn() == TurnStatus.NOFAINT);

        System.out.println(playersPokemon.getHp() == 0 ? "You Lose." : "You win!");
    }
    private MoveStatus makeMove(Pokemon defender, Pokemon attacker, Move attackerMove) {

        if (atkLands(attackerMove)){
            defender.receiveAttack(attackerMove);
            System.out.println(attacker.getName() + " used " + attackerMove);
            System.out.println(stats());
            if (defender.getHp() == 0) {
                System.out.println(defender.getName() + " has fainted");
                return MoveStatus.FAINT;
            }
        }
        else {
            System.out.println(attacker.getName() + " missed");
            return MoveStatus.MISS;
        }
        return MoveStatus.HIT;
    }
    private String stats(){
        return playersPokemon + "\n" + computerPokemon;
    }
}
