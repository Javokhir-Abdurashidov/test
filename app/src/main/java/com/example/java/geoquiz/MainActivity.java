package com.example.java.geoquiz;

import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button true_button;
    private Button false_button;
    private TextView question_TextView;
    private Button next_button;
    private Question[] questionsObject=new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int currentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            currentIndex=savedInstanceState.getInt("index",0);
        }

        init();

        updateQuestion();

        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            checkAnswer(true);
            }
        });
        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            checkAnswer(false);
            }
        });
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            currentIndex=(currentIndex+1)%questionsObject.length;
              updateQuestion();
            }
        });


    }

    private void init(){
        true_button=(Button)findViewById(R.id.true_button);
        false_button=(Button)findViewById(R.id.false_button);
        next_button=(Button)findViewById(R.id.next_button);
        question_TextView=(TextView)findViewById(R.id.question_textview);

    }
    private void updateQuestion(){
        int question=questionsObject[currentIndex].getQuestionResID();
        question_TextView.setText(question);
    }
    private void checkAnswer(boolean answerTrue){
        boolean correctAnswer=questionsObject[currentIndex].isAnswer();

        if(answerTrue==correctAnswer){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Incorrect", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("index", currentIndex);
    }

}
