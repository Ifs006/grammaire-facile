package com.example.gramairefacile.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.QuizDbHelper;

public class QuizLvActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tvQuestion;
    private ImageView ivQuestionCount;
    private RadioGroup radiogroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private ImageButton ibtnContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizlv1);

        tvQuestion = (TextView) findViewById(R.id.tv_question1);
        ivQuestionCount = (ImageView) findViewById(R.id.img_question_count);
        radiogroup = (RadioGroup) findViewById(R.id.radio_group);
        rb1 = (RadioButton) findViewById(R.id.radio_button1);
        rb2 = (RadioButton) findViewById(R.id.radio_button2);
        rb3 = (RadioButton) findViewById(R.id.radio_button3);
        rb4 = (RadioButton) findViewById(R.id.radio_button4);
        ibtnContinue = (ImageButton) findViewById(R.id.ibtn_continue);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
//        questionList = dbHelper.getAllQuestions();
//        questionCountTotal = questionList.size();

        showNextQuestion();

        ibtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!answered) {
//                    if (rb1.isChecked()) ||
//                    (rb2.isChecked()) || (rb3.isChecked()) || (rb4.isChecked()) {
//                        checkAnswer();
//                    }else{
//                        Toast.makeText(QuizLvActivity.this, "please select an answer", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    showNextQuestion();
//                }
            }
        });

    }

    private void showNextQuestion() {


    }

    private void checkAnswer() {


    }

    private void showSolution() {


    }

    private void finishQuiz() {


    }
}
