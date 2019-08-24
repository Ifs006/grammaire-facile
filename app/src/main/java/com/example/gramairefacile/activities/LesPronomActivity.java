package com.example.gramairefacile.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

public class LesPronomActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton ibtnLpps;
    private ImageButton ibtnLpt;
    private ImageButton ibtnLpis;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_pronom);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        ibtnLpps = (ImageButton) findViewById(R.id.ibtn_Lpps);
        ibtnLpt = (ImageButton) findViewById(R.id.ibtn_Lpt);
        ibtnLpis = (ImageButton) findViewById(R.id.ibtn_Lpis);
        setSupportActionBar(toolbar);

        ibtnLpps.setOnClickListener(this);
        ibtnLpt.setOnClickListener(this);
        ibtnLpis.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ibtn_Lpps: {
                intent = new Intent(this, LesPronomMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lpt: {
                intent = new Intent(this, LesPronomMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lpis: {
                intent = new Intent(this, LesPronomMateriActivity.class);
                break;
            }
        }

        if (intent != null)
            startActivity(intent);
    }
}
