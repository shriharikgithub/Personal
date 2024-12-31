package com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies;

import com.scaler.lld.machinecoding.tictactoe.models.Move;
import com.scaler.lld.machinecoding.tictactoe.models.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O1DiagonalWinningStrategy implements WinningStrategy {

    private Map<Character, Integer> leftDiagonalMap, rightDiagonalMap;

    private int boardSize;

    public O1DiagonalWinningStrategy(int boardSize, List<Player> playerList) {
        this.boardSize = boardSize;
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
        for (Player player : playerList) {
            leftDiagonalMap.put(player.getSymbol(), 0);
            rightDiagonalMap.put(player.getSymbol(), 0);
        }
    }

    @Override
    public boolean checkWinnerWithMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        if (row == col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);
        }
        if (row + col == boardSize - 1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);
        }

        return leftDiagonalMap.get(symbol) == boardSize || rightDiagonalMap.get(symbol) == boardSize;
    }

    @Override
    public void handleUndo(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        if (row == col) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) - 1);
        }
        if (row + col == boardSize - 1) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) - 1);
        }

    }


}
