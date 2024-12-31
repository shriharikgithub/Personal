package com.scaler.lld.machinecoding.tictactoe.models;

import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategyfactory.BotPlayingStrategyFactory;

import java.util.List;

public class BotPlayer extends Player {

    BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public Cell makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
