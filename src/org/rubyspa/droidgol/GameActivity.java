package org.rubyspa.droidgol;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.widget.TextView;

public class GameActivity extends Activity
{

    private TextView boardView;
    private Pair<Integer, Integer> boardDimensions;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initialize();
    }

    private void initialize() {
        this.boardView = (TextView) findViewById(R.id.gameBoard);
        this.boardDimensions = computeDimensions();
        this.boardView.setText(String.format(
                "\n\n\n\n\n\n                " +
                "\n     Game will extend over" +
                "\n     %d columns and" +
                "\n     %d rows" +
                "\n     (touch to start)", boardDimensions.first, boardDimensions.second));
    }

    private Pair<Integer, Integer> computeDimensions() {
        // TODO: How do you reliably find out how many 'o's per line and how many lines we can fit on the screen?
        Integer width = 38;
        Integer height = 28;
        return Pair.create(width, height);
    }

}
