package com.tomlavalord.pokemon.game;

import com.tomlavalord.pokemon.Pokemon;
import com.tomlavalord.pokemon.moves.Move;

import java.util.Scanner;

public class OneOnOne {

    protected Pokemon playersPokemon;
    protected Pokemon computerPokemon;
    private enum MoveStatus {MISS,FAINT,HIT}

    private enum TurnStatus {COMPUTERFAINT, NOFAINT, PLAYERFAINT}
    public OneOnOne(Player player, Pokemon enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a Pokemon");
        System.out.println(player.partyToString());
        int x = scanner.nextInt();
        this.playersPokemon = player.party[x];
        this.computerPokemon = enemy;
    }
    private boolean atkLands(Move move){
        return ((int)(Math.random()*100+1) < move.getAccuracy() +1);
    }

//    public boolean doTurn(){
//        int numEnemyMove = (int)(Math.random()*4);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Choose a move");
//        System.out.println(playersPokemon.movesToString());
//        int numPlayerMove = scanner.nextInt();
//        if(faster()){
//            int temp = numPlayerMove;
//            numPlayerMove = numEnemyMove;
//            numEnemyMove = temp;
//        }
//
//        if (atkLands(faster.getMoves()[numPlayerMove])) {
//            slower.receiveAttack(faster.getMoves()[numPlayerMove]);
//            System.out.println(faster.getName() + " used " + faster.getMoves()[numPlayerMove]);
//            System.out.println(playersPokemon + "\n" + enemy);
//            if (slower.getHp() == 0) {
//                System.out.println(slower.getName() + " has fainted");
//                scanner.nextLine();
//                return false;
//            }
//        }
//        else {
//            System.out.println(faster.getName() + " missed");
//            scanner.nextLine();
//        }
//        scanner.nextLine();
//        scanner.nextLine();
//        if (atkLands(slower.getMoves()[numEnemyMove])) {
//            faster.receiveAttack(slower.getMoves()[numEnemyMove]);
//            System.out.println(slower.getName() + " used " + slower.getMoves()[numEnemyMove]);
//            System.out.println(playersPokemon + "\n" + enemy);
//            scanner.nextLine();
//            if (faster.getHp() == 0) {
//                System.out.println(faster.getName() + " has fainted");
//                scanner.nextLine();
//                return false;
//            }
//        }
//        else {
//            System.out.println(faster.getName() + " missed");
//            scanner.nextLine();
//        }
//        return true;
//    }

    public TurnStatus doTurn() {
        Move computerMove = computerPokemon.getMoves()[(int) (Math.random() * 4)];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a move");
        System.out.println(playersPokemon.movesToString());
        int numPlayerMove = scanner.nextInt();
        int isEqual = (playersPokemon.getSpeed() == computerPokemon.getSpeed() ? (int)(Math.random()*10+1) : 0);
        if (playersPokemon.getSpeed() < computerPokemon.getSpeed() || isEqual > 5){
            if (makeMove(playersPokemon, computerPokemon, computerMove) == MoveStatus.FAINT){
                return TurnStatus.PLAYERFAINT;
            }
            else if (makeMove(computerPokemon, playersPokemon, playersPokemon.getMoves()[numPlayerMove]) == MoveStatus.FAINT){
                return TurnStatus.COMPUTERFAINT;
            }
        }
        else  {
            if (makeMove(computerPokemon, playersPokemon, playersPokemon.getMoves()[numPlayerMove]) == MoveStatus.FAINT){
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
            System.out.println("Turn " + turn);
            System.out.println(playersPokemon + "\n" + computerPokemon);
            turn++;
        }while(doTurn() == TurnStatus.NOFAINT);

        System.out.println(playersPokemon.getHp() == 0 ? "You Lose." : "You win!");
    }
    private MoveStatus makeMove(Pokemon defender, Pokemon attacker, Move attackerMove){

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
