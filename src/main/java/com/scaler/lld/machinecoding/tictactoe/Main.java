package com.scaler.lld.machinecoding.tictactoe;

import com.scaler.lld.machinecoding.tictactoe.controllers.GameController;
import com.scaler.lld.machinecoding.tictactoe.exceptions.InvalidParamsException;
import com.scaler.lld.machinecoding.tictactoe.models.*;
import com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies.O1ColWinningStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies.O1DiagonalWinningStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies.O1RowWinningStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Game
        // Begin the game
        // till the time game is in progress
            // check if someone wants to undo, if y -> perform undo
            // make move
            // for bot just make a move, for player get the input and validate

        // print result

        // set the board size, set the players with their symbols

        int boardSize = 4;
        List<Player> players = List.of(
                new Player("Shrihari", '#', PlayerType.HUMAN),
                new Player("Naman", 'X', PlayerType.HUMAN),
                new BotPlayer("Bot", 'O', BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new O1ColWinningStrategy(boardSize, players),
                new O1RowWinningStrategy(boardSize, players),
                new O1DiagonalWinningStrategy(boardSize, players)
        );

        Game game = null;

        try {
             game = Game
                    .getGameBuilder()
                    .setBoardSize(boardSize)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();
        } catch (InvalidParamsException e) {
            System.out.println("Something went wrong " + e);
            return;
        }

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        while (GameStatus.IN_PROGRESS.equals(gameController.getGameStatus(game))) {
            System.out.println("Current Board looks like this");
            gameController.printBoard(game);
            System.out.println("Does anyone want to undo (Y/N) ?");
            String undo = scanner.next();
            if (undo.equalsIgnoreCase("Y")) {
                gameController.performUndo(game);
            } else {
                gameController.makeMove(game);
            }
        }
        System.out.println("Game has ended.");
        gameController.printResult(game);
    }
}
