package com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies;

import com.scaler.lld.machinecoding.tictactoe.models.Move;
import com.scaler.lld.machinecoding.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O1RowWinningStrategy implements WinningStrategy {

    private List<Map<Character, Integer>> rowMapList;
    private int boardSize;

    public O1RowWinningStrategy(int boardSize, List<Player> players) {
        this.boardSize = boardSize;
        this.rowMapList = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            rowMapList.add(new HashMap<>());
            for (Player player : players) {
                rowMapList.get(i).put(player.getSymbol(), 0);
            }
        }
    }

    @Override
    public boolean checkWinnerWithMove(Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getCell().getPlayer().getSymbol();
        Map<Character, Integer> rowMap = rowMapList.get(row);
        rowMap.replace(symbol, rowMap.get(symbol) + 1);
        return rowMap.get(symbol) == boardSize;
    }

    @Override
    public void handleUndo(Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getCell().getPlayer().getSymbol();
        Map<Character, Integer> rowMap = rowMapList.get(row);
        rowMap.replace(symbol, rowMap.get(symbol) - 1);
    }
}
