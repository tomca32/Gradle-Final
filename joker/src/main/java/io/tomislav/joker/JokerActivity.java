package io.tomislav.joker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokerActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "JOKE_EXTRA";

    private TextView jokeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
        jokeView = (TextView) findViewById(R.id.joke_text);
        displayJoke();
    }

    private void displayJoke() {
        jokeView.setText(getIntent().getStringExtra(JOKE_EXTRA));
    }
}
