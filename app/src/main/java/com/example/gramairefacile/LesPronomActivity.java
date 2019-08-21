package com.example.gramairefacile;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
            Intent intent = new Intent (LesPronomActivity.this,lpm1.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.p2);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesPronomActivity.this,lpm2.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.p3);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesPronomActivity.this,lpm3.class);
            startActivity(intent);
        }
    });}
}
