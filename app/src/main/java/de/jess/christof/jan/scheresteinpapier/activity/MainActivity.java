package de.jess.christof.jan.scheresteinpapier.activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import de.jess.christof.jan.scheresteinpapier.R;
import de.jess.christof.jan.scheresteinpapier.model.Game;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.GameValue;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Paper;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Scissors;
import de.jess.christof.jan.scheresteinpapier.model.gamevalues.Stone;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";
    private final String LOG_INFO_SELECT_SCISSORS = "User selected scissors.";
    private final String LOG_INFO_SELECT_STONE = "User selected stone.";
    private final String LOG_INFO_SELECT_PAPER = "User selected paper.";
    private final String LOG_INFO_START_GAME = "Start Game...";
    private final String LOG_INFO_GAME_RESULT = "Game result: ";
    private final String LOG_DEBUG_CREATE_VIEW = "Create view.";
    private Game game;

    public MainActivity() {
        this.game = new Game();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, LOG_DEBUG_CREATE_VIEW);
    }

    public void selectScissors(View view) {
        Log.i(LOG_TAG, LOG_INFO_SELECT_SCISSORS);
        this.startGame(new Scissors());
    }

    public void selectStone(View view) {
        Log.i(LOG_TAG, LOG_INFO_SELECT_STONE);
        this.startGame(new Stone());
    }

    public void selectPaper(View view) {
        Log.i(LOG_TAG, LOG_INFO_SELECT_PAPER);
        this.startGame(new Paper());
    }

    private void setResultText(String text) {
        TextView resultView = this.findViewById(R.id.tvResult);
        resultView.setText(text);
    }

    private void setComputerSelection(GameValue gameValue) {
        Resources res = getResources();
        String text = res.getString(R.string.computer_selection, gameValue.getValue());
        TextView computerSelectionView = this.findViewById(R.id.tvComputerSelection);
        computerSelectionView.setText(text);
    }

    private void startGame(GameValue playerValue) {
        Log.i(LOG_TAG, LOG_INFO_START_GAME);
        GameValue computerValue = this.game.generateComputerValue();
        this.setComputerSelection(computerValue);
        Game.GameResult gameResult = this.game.havePlayerWon(playerValue, computerValue);
        Log.i(LOG_TAG, LOG_INFO_GAME_RESULT + gameResult);
        String resultText = this.getResultText(gameResult);
        this.setResultText(resultText);
    }

    private String getResultText(Game.GameResult gameResult) {
        Resources res = getResources();
        switch (gameResult) {
            case WON:
                return res.getString(R.string.won_text);
            case DRAW:
                return res.getString(R.string.draw_text);
            case LOST:
                return res.getString(R.string.lost_text);
        }
        return "";
    }
}
