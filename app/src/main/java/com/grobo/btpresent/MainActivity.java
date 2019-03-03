package com.grobo.btpresent;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTextView, timeTextView, questionTextView;
    private Button button1, button2, button3, button4;
    private TextView resultTextView;
    private Button playButton;

    private LinearLayout linearLayout;
    private GridLayout gridLayout;

    private int correctQuestions;
    private int totalQuestions;
    private int locationOfCorrect;

    ArrayList<Integer> answers = new ArrayList<Integer>();

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
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });

        linearLayout = findViewById(R.id.linear_layout);
        gridLayout = findViewById(R.id.grid_layout);

    }

    private void startQuiz(){

        createQuestion();

        resultTextView.setText("");
        timeTextView.setText("30s");
        correctQuestions = 0;
        totalQuestions = 0;
        gridLayout.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.INVISIBLE);
        scoreTextView.setText("0/0");

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                timeTextView.setText("0s");
                gridLayout.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
                playButton.setText("Play Again");
                playButton.setVisibility(View.VISIBLE);
                showScore();
            }
        }.start();

    }

    private void createQuestion(){

        answers.clear();

        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        locationOfCorrect = random.nextInt(4);

        for (int i = 0; i < 4; i++){

            if(i == locationOfCorrect){
                answers.add(a+b);
            } else {

                int wrongAnswer = random.nextInt(41);

                while (wrongAnswer == (a+b)){
                    wrongAnswer = random.nextInt(41);
                }

                answers.add(wrongAnswer);
            }

        }

        String question = String.valueOf(a) + "+" + String.valueOf(b);
        questionTextView.setText(question);

        button1.setText(String.valueOf(answers.get(0)));
        button2.setText(String.valueOf(answers.get(1)));
        button3.setText(String.valueOf(answers.get(2)));
        button4.setText(String.valueOf(answers.get(3)));

    }

    public void checkAnswer(View view){

        if(view.getTag().toString().equals(String.valueOf(locationOfCorrect))){
            correctQuestions++;
            resultTextView.setText("Correct Answer");
        } else {
            resultTextView.setText("Incorrect Answer");
        }

        totalQuestions++;
        scoreTextView.setText(String.valueOf(correctQuestions) + "/" + String.valueOf(totalQuestions));

        createQuestion();

    }

    private void showScore(){

        resultTextView.setText("Score = " + String.valueOf(correctQuestions) + "/" + String.valueOf(totalQuestions));

    }

}
