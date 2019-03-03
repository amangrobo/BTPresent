package com.grobo.btpresent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView, timeTextView, questionTextView;
    private Button button1, button2, button3, button4;
    private TextView resultTextView;
    private Button playButton;

    private LinearLayout linearLayout;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){

        scoreTextView = findViewById(R.id.score_text_view);
        timeTextView = findViewById(R.id.time_text_view);
        questionTextView = findViewById(R.id.question_text_view);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        resultTextView = findViewById(R.id.result_text_view);
        playButton = findViewById(R.id.play_button);

        linearLayout = findViewById(R.id.linear_layout);
        gridLayout = findViewById(R.id.grid_layout);

    }

    private void startQuiz(){}

    public void checkAnswer(View view){}

    private void createQuestion(){}

    private void showScore(){}

}
