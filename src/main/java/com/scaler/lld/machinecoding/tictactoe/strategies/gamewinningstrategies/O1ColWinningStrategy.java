package com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies;

import com.scaler.lld.machinecoding.tictactoe.models.Move;
import com.scaler.lld.machinecoding.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O1ColWinningStrategy implements WinningStrategy {

    private List<Map<Character, Integer>> colMapList;

    private int boardSize;

    public O1ColWinningStrategy(int boardSize, List<Player> players) {
        this.boardSize = boardSize;
        this.colMapList = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            colMapList.add(new HashMap<>());
            for (Player player : players) {
                colMapList.get(i).put(player.getSymbol(), 0);
            }
        }
    }

    @Override
    public boolean checkWinnerWithMove(Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getCell().getPlayer().getSymbol();
        Map<Character, Integer> colMap = colMapList.get(col);
        colMap.replace(symbol, colMap.get(symbol) + 1);
        return colMap.get(symbol) == boardSize;
    }

    @Override
    public void handleUndo(Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getCell().getPlayer().getSymbol();
        Map<Character, Integer> colMap = colMapList.get(col);
        colMap.replace(symbol, colMap.get(symbol) - 1);
    }
}
