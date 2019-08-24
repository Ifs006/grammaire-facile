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

    private ImageButton ibtnlvr;
    private ImageButton ibtnlvir;
    private ImageButton ibtnlcdp;
    private ImageButton ibtnln;
    private ImageButton ibtnlfis;
    private ImageButton ibtnli;
    private ImageButton ibtnpdi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_verbes);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);

        ibtnlvr = (ImageButton) findViewById(R.id.ibtn_lvr);
        ibtnlvir = (ImageButton) findViewById(R.id.ibtn_lvr);
        ibtnlcdp = (ImageButton) findViewById(R.id.ibtn_lcdp);
        ibtnln = (ImageButton) findViewById(R.id.ibtn_ln);
        ibtnlfis = (ImageButton) findViewById(R.id.ibtn_lfis);
        ibtnli = (ImageButton) findViewById(R.id.ibtn_li);
        ibtnpdi = (ImageButton) findViewById(R.id.ibtn_pdi);
        setSupportActionBar(toolbar);


        ibtnlvr.setOnClickListener(this);
        ibtnlvir.setOnClickListener(this);
        ibtnlcdp.setOnClickListener(this);
        ibtnln.setOnClickListener(this);
        ibtnlfis.setOnClickListener(this);
        ibtnli.setOnClickListener(this);
        ibtnpdi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ibtn_lvr: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_lvir: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_lcdp: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_ln: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_lfis: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_li: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
            case R.id.ibtn_pdi: {
                intent = new Intent(this, LesVerbesMateriActivity.class);
                break;
            }
        }

        if (intent != null)
            startActivity(intent);
    }


}