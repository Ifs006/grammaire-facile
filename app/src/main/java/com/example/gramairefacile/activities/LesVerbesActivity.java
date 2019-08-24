package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

public class LesVerbesActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    private ImageButton ibtnLvr;
    private ImageButton ibtnLvir;
    private ImageButton ibtnLcdp;
    private ImageButton ibtnLn;
    private ImageButton ibtnLfis;
    private ImageButton ibtnLi;
    private ImageButton ibtnPdi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_verbes);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);

        ibtnLvr = (ImageButton) findViewById(R.id.ibtn_Lvr);
        ibtnLvir = (ImageButton) findViewById(R.id.ibtn_Lvr);
        ibtnLcdp = (ImageButton) findViewById(R.id.ibtn_Lcdp);
        ibtnLn = (ImageButton) findViewById(R.id.ibtn_Ln);
        ibtnLfis = (ImageButton) findViewById(R.id.ibtn_Lfis);
        ibtnLi = (ImageButton) findViewById(R.id.ibtn_Li);
        ibtnPdi = (ImageButton) findViewById(R.id.ibtn_Pdi);
        setSupportActionBar(toolbar);


        ibtnLvr.setOnClickListener(this);
        ibtnLvir.setOnClickListener(this);
        ibtnLcdp.setOnClickListener(this);
        ibtnLn.setOnClickListener(this);
        ibtnLfis.setOnClickListener(this);
        ibtnLi.setOnClickListener(this);
        ibtnPdi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ibtn_Lvr: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lvir: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lcdp: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Ln: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Lfis: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Li: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_Pdi: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
        }

        if (intent != null)
            startActivity(intent);
    }


}