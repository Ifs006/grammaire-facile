package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

public class LesAdjectifActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ibtnLap;
    private ImageButton ibtnLade;
    private ImageButton ibtnLaq;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_adjectif);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        ibtnLap = (ImageButton) findViewById(R.id.ibtn_Lap);
        ibtnLade = (ImageButton) findViewById(R.id.ibtn_Lade);
        ibtnLaq = (ImageButton) findViewById(R.id.ibtn_Laq);
        setSupportActionBar(toolbar);

        ibtnLap.setOnClickListener(this);
        ibtnLade.setOnClickListener(this);
        ibtnLaq.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ibtn_Lap: {
                intent = new Intent(this, LesAdjectifMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lade: {
                intent = new Intent(this, LesAdjectifMateriActivity.class);
                break;
            }
            case R.id.ibtn_Laq: {
                intent = new Intent(this, LesAdjectifMateriActivity.class);
                break;
            }
        }
        if (intent != null)
            startActivity(intent);

    }

}
