package com.example.gramairefacile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LesVerbesActivity extends AppCompatActivity {
    ImageButton pindah;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_verbes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    pindah = (ImageButton) findViewById(R.id.la1);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm1.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.la2);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm2.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.la3);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm3.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.lv4);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm4.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.lv5);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm5.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.lv6);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this,lvm6.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.lv7);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesVerbesActivity.this, lvm7.class);
            startActivity(intent);
        }
    });


    teks = (TextView) findViewById(R.id.LesVerbes);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/Warung Kopi.otf");
        teks.setTypeface(customfont);
    };


}

