package com.scaler.lld.machinecoding.tictactoe.models;

import com.scaler.lld.machinecoding.tictactoe.exceptions.InvalidParamsException;
import com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private int boardSize;
    private Board board;
    private List<Player> players;
    private int currentPlayerIdx;
    private List<Move> moves;
    private GameStatus gameStatus;
    private List<WinningStrategy> winningStrategies;
    private Player winner;

    private Game(GameBuilder gameBuilder) {
        this.board = new Board(gameBuilder.boardSize);
        this.currentPlayerIdx = 0;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players = gameBuilder.players;
        this.boardSize = gameBuilder.boardSize;
        this.winningStrategies = gameBuilder.winningStrategies;
    }

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

    public void printBoard() {
        board.printBoard();
    }

    public void printResult() {
        if (GameStatus.ENDED.equals(gameStatus)) {
            if (winner != null) {
                System.out.println(winner.getName() + " has won the game.");
            } else {
                System.out.println("Game is draw");
            }
        } else {
            System.out.println("Game status is " + gameStatus);
        }
    }

    public void makeMove() {
        Player currentPlayer = players.get(currentPlayerIdx);
        Cell proposedCell = currentPlayer.makeMove(board);
        boolean isValidMove = isValidMove(proposedCell);
        if (isValidMove) {
            Move move = new Move(proposedCell, currentPlayer);
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            Cell cell = board.getCells().get(row).get(col);
            cell.setCellStatus(CellStatus.FILLED);
            cell.setPlayer(currentPlayer);
            moves.add(new Move(cell, currentPlayer));
            boolean hasWinner = false;
            for (WinningStrategy winningStrategy : winningStrategies) {
                hasWinner = winningStrategy.checkWinnerWithMove(move);
            }
            if (hasWinner) {
                gameStatus = GameStatus.ENDED;
                winner = currentPlayer;
            } else if (moves.size() == boardSize * boardSize){
                gameStatus = GameStatus.ENDED;
            } else {
                currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
            }
        } else {
            System.out.println("Invalid move, retry.");
        }
    }

    private boolean isValidMove(Cell proposedCell) {
        int row = proposedCell.getRow();
        int col = proposedCell.getCol();
        if (row < 0 || col < 0 || row >= boardSize || col >= boardSize) {
            return false;
        }
        return CellStatus.EMPTY.equals(board.getCells().get(row).get(col).getCellStatus());
    }

    public void performUndo() {
        if (moves.size() == 0) {
            System.out.println("No moves performed, can't undo");
            return;
        }
        Move move = moves.get(moves.size() - 1);
        for (WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.handleUndo(move);
        }

        Cell cell = move.getCell();
        cell.clear();
        moves.remove(move);
        currentPlayerIdx = Math.floorMod(currentPlayerIdx - 1, players.size());
    }

    public static class GameBuilder {
        private List<Player> players;
        private int boardSize;
        private List<WinningStrategy> winningStrategies;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public void validate() throws InvalidParamsException {
            boolean areParamsValid = boardSize > 1
                    && players.size() == boardSize - 1;

            if (areParamsValid) {
                Set<Character> characters = new HashSet<>();
                for (Player player : players) {
                    if (characters.contains(player.getSymbol())) {
                        areParamsValid = false;
                        break;
                    }
                    characters.add(player.getSymbol());
                }
            }
            if (!areParamsValid) {
                throw new InvalidParamsException("Invalid parameters provided, cannot create the game : Players {" + players + "}, Board size : " + boardSize);
            }
        }

        public Game build() throws InvalidParamsException {
            validate();
            return new Game(this);
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
