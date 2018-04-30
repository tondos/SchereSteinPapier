package de.jess.christof.jan.scheresteinpapier.model;


import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

import de.jess.christof.jan.scheresteinpapier.model.gamevalues.GameValue;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Paper;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Scissors;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Stone;

public class Game {

    public enum GameResult{
        WON, LOST, DRAW
    }

    private static final String LOG_TAG = "Game";
    private final String LOG_INFO_COMPUTER_VALUE = "Computer selected: ";
    private final int RND_MAX = 3;

    public Game() {
    }

    public GameResult havePlayerWon(GameValue playerValue, GameValue computerValue) {
        int compareValue = playerValue.compareTo(computerValue);
        GameResult gameResult = this.convertToGameResult(compareValue);
        return gameResult;
    }

    public GameValue generateComputerValue(){
        int randomInt = ThreadLocalRandom.current().nextInt(RND_MAX);
        GameValue computerValue = null;
        switch (randomInt) {
            case 0: computerValue = new Scissors(); break;
            case 1: computerValue = new Stone(); break;
            case 2: computerValue = new Paper(); break;
            default: computerValue = new Scissors();
        }
        Log.i(LOG_TAG, LOG_INFO_COMPUTER_VALUE + computerValue.getValue());
        return computerValue;
    }

    private GameResult convertToGameResult(int compareValue) {
        switch (compareValue) {
            case 1: return GameResult.WON;
            case 0: return GameResult.DRAW;
            case -1: return GameResult.LOST;
            default: return GameResult.DRAW;
        }
    }

}
