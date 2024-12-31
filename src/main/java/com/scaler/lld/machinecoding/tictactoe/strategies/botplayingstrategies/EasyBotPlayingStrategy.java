package com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies;

import com.scaler.lld.machinecoding.tictactoe.models.Board;
import com.scaler.lld.machinecoding.tictactoe.models.Cell;
import com.scaler.lld.machinecoding.tictactoe.models.CellStatus;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Cell makeMove(Board board) {
        List<List<Cell>> cells = board.getCells();
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.size(); j++) {
                Cell cell = cells.get(i).get(j);
                if (cell.getCellStatus().equals(CellStatus.EMPTY)) {
                    return cell;
                }
            }
        }
        return null; //
    }
}
