package com.scaler.lld.machinecoding.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;

    public Board(int boardSize) {
        cells = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                cells.get(i).add(new Cell(i, j, CellStatus.EMPTY));
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); i++) {
            System.out.print("|");
            for (int j = 0; j < cells.get(i).size(); j++) {
                Cell cell = cells.get(i).get(j);
                if (CellStatus.EMPTY.equals(cell.getCellStatus())) {
                    System.out.print(" - |");
                } else {
                    System.out.print(" " + cell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }
}
