package com.scaler.lld.machinecoding.tictactoe.strategies.gamewinningstrategies;

import com.scaler.lld.machinecoding.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinnerWithMove(Move move);

    void handleUndo(Move move);
}
