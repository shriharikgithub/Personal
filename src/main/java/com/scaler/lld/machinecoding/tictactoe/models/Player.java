package com.scaler.lld.machinecoding.tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Cell makeMove(Board board) {
        System.out.println("It's " + name + "'s turn.");
        System.out.println("Enter the row : ");
        int row = scanner.nextInt();
        System.out.println("Enter the col: ");
        int col = scanner.nextInt();
        Cell cell = new Cell(row, col, CellStatus.FILLED);
        cell.setPlayer(this);
        return cell;
    }
}
