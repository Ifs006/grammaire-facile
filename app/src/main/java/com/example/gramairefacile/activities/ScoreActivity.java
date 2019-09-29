package com.example.gramairefacile.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.utils.Constants;

public class ScoreActivity extends AppCompatActivity {

    private int score;

    private TextView infoScore, infoResult;
    private TextView correctAnswer, wrongAnswer;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        readBundles();
        initViews();
    }

    private void readBundles() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            score = bundle.getInt(Constants.EXTRA_SCORE, 0);
        }
    }

    private void initViews() {
        infoScore = findViewById(R.id.tv_score);
        infoResult = findViewById(R.id.tv_result);
        correctAnswer = findViewById(R.id.tv_correct_answer_count);
        wrongAnswer = findViewById(R.id.tv_wrong_answer_count);
        btnFinish = findViewById(R.id.btn_finish);

        infoScore.setText(String.valueOf(score * 10));
        correctAnswer.setText(String.valueOf(score));
        wrongAnswer.setText(String.valueOf(10 - score));

        if (score == 10) {
            infoResult.setText("Bravo!");
        } else if (score >= 8 && score <= 9) {
            infoResult.setText("Super!");
        } else if (score >= 5 && score <= 7) {
            infoResult.setText("Pas mal!");
        } else {
            infoResult.setText(":(");
        }

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
