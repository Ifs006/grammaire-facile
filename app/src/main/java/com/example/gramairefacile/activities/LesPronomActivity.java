package com.example.gramairefacile.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.lpm1;
import com.example.gramairefacile.lpm2;
import com.example.gramairefacile.lpm3;

public class LesPronomActivity extends AppCompatActivity {
    ImageButton pindah;
    TextView teks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_pronom);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     pindah = (ImageButton) findViewById(R.id.p1);
     pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesPronomActivity.this, lpm1.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.p2);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesPronomActivity.this, lpm2.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.p3);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesPronomActivity.this, lpm3.class);
            startActivity(intent);
        }
    });}
}
