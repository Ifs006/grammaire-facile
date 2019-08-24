package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

public class LesArticlesActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ibtnLad;
    private ImageButton ibtnLai;
    private ImageButton ibtnLap;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_articles);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        ibtnLad = (ImageButton) findViewById(R.id.ibtn_Lad);
        ibtnLai = (ImageButton) findViewById(R.id.ibtn_Lai);
        ibtnLap = (ImageButton) findViewById(R.id.ibtn_Lap);
        setSupportActionBar(toolbar);

        ibtnLad.setOnClickListener(this);
        ibtnLai.setOnClickListener(this);
        ibtnLap.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ibtn_Lad: {
                intent = new Intent(this, LesArticleMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lai: {
                intent = new Intent(this, LesArticleMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lap: {
                intent = new Intent(this, LesArticleMateriActivity.class);
                break;
            }
        }

        if (intent != null)
            startActivity(intent);
    }
}