package org.rubyspa.droidgol;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import static org.rubyspa.droidgol.GamePrinter.print;

public class GameActivity extends Activity implements View.OnClickListener {

    private TextView boardView;
    private Pair<Integer, Integer> boardDimensions;
    private volatile boolean gameRunning = false;
    private Game game;
    private Thread gameThread;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialize();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initialize();
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        gameThread.interrupt();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        initialize();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameThread.interrupt();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initialize();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gameThread.interrupt();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameThread.interrupt();
    }

    private void initialize() {
        gameRunning = false;
        this.boardView = (TextView) findViewById(R.id.gameBoard);
        this.boardView.setEnabled(true);
        this.boardDimensions = computeDimensions();
        this.game = new Game(this.boardDimensions.first, this.boardDimensions.second);
        this.boardView.setText(String.format(
                "\n\n\n\n\n\n                " +
                        "\n     Game will extend over" +
                        "\n     %d columns and" +
                        "\n     %d rows" +
                        "\n     (touch to start)", boardDimensions.first, boardDimensions.second));
        gameThread = new Thread() {
            @Override
            public void run() {
                try {
                    while (gameRunning && !isInterrupted()) {
                        Thread.sleep(150, 0);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Game nextGameState = game.evolve();
                                boardView.setText(print(nextGameState));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
    }

    private Pair<Integer, Integer> computeDimensions() {
        // TODO: How do you reliably find out how many 'o's per line and how many lines we can fit on the screen?
        Integer width = 38;
        Integer height = 28;
        return Pair.create(width, height);
    }


    @Override
    public void onClick(View v) {
        if (!gameRunning) gameThread.start();
        this.gameRunning = true;
        this.boardView.setEnabled(false);
    }

}
