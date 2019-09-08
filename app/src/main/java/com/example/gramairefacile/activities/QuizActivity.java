package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gramairefacile.R;
import com.example.gramairefacile.adapters.ViewPagerAdapter;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.entity.Question;
import com.example.gramairefacile.database.entity.Quiz;
import com.example.gramairefacile.fragments.QuizFragment;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.widgets.LockedViewPager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private LockedViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Button continueButton;
    private ProgressBar progressBar;
    private TextView tvProgress, titleCommand;

    private int idMateri;
    private List<Fragment> fragments;
    private int currentScore = 0;

    private DatabaseHelper db;
    private Quiz quiz;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Initialize database helper
        db = new DatabaseHelper(this);

        readBundle();
        initViews();
    }

    private void readBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idMateri = bundle.getInt(Constants.EXTRA_ID_MATERI, 0);
        }
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewpager);
        progressBar = findViewById(R.id.progress_bar);
        tvProgress = findViewById(R.id.tv_progress);
        continueButton = findViewById(R.id.btn_continue);
        titleCommand = findViewById(R.id.tv_command_quiz);

        quiz = db.getQuizByMateri(idMateri);
        fragments = new ArrayList<>();

        titleCommand.setText(quiz.getTitleQuiz());

        questions = DatabaseHelper.toQuestionList(quiz.getQuestions());
        Collections.shuffle(questions);

        for (Question question : questions) {
            fragments.add(QuizFragment.newInstance(question.getQuestion(), new Gson().toJson(question.getChoices())));
        }

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                int currentProgress = position + 1;
                tvProgress.setText(String.format("%d/10", currentProgress));
                progressBar.setProgress(currentProgress);

                if (currentProgress == 10) {
                    continueButton.setText("Finish");
                } else {
                    continueButton.setText("Continuer");
                }
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextQuestion();
            }
        });
    }

    private void showNextQuestion() {
        checkAnswer();

        if (viewPager.getCurrentItem() == 9) {
            finishQuiz();
        } else {
            QuizFragment fragment = (QuizFragment) viewPagerAdapter.getItem(viewPager.getCurrentItem());
            if (fragment.getAnswer().isEmpty()) {
                Toast.makeText(this, "Please select the answer!", Toast.LENGTH_SHORT).show();
                return;
            }
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    private void checkAnswer() {
        QuizFragment fragment = (QuizFragment) viewPagerAdapter.getItem(viewPager.getCurrentItem());
        Question question = questions.get(viewPager.getCurrentItem());
        String answer = question.getChoices()[question.getCorrectIndexofChoices()];

        Log.i("@ANSWER", answer);

        if (fragment.getAnswer().equals(answer)) {
            currentScore += 1;
        }
    }

    private void finishQuiz() {
        startActivity(new Intent(this, ScoreActivity.class)
                .putExtra(Constants.EXTRA_SCORE, currentScore));

        finish();
    }

}
