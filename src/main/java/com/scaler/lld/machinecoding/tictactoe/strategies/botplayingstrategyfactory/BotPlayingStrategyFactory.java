package com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategyfactory;

import com.scaler.lld.machinecoding.tictactoe.models.BotDifficultyLevel;
import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies.EasyBotPlayingStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies.HardBotPlayingStrategy;
import com.scaler.lld.machinecoding.tictactoe.strategies.botplayingstrategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotPlayingStrategy();
//        return switch (botDifficultyLevel) {
//            case EASY -> new EasyBotPlayingStrategy();
//            case MEDIUM -> new MediumBotPlayingStrategy();
//            case HARD -> new HardBotPlayingStrategy();
//        };
    }
}
