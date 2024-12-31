package com.scaler.lld.machinecoding.tictactoe.controllers;

import com.scaler.lld.machinecoding.tictactoe.models.Game;
import com.scaler.lld.machinecoding.tictactoe.models.GameStatus;

public class GameController {

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void performUndo(Game game) {
        game.performUndo();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void printResult(Game game) {
        game.printResult();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
