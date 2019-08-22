package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gramairefacile.LesArticleActivity;
import com.example.gramairefacile.R;

public class LesArticlesActivity extends AppCompatActivity {
    ImageButton pindah;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_articles);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    pindah = (ImageButton) findViewById(R.id.la1);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesArticlesActivity.this, LesArticleActivity.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.la2);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesArticlesActivity.this, lam2.class);
            startActivity(intent);
        }
    });

    pindah = (ImageButton) findViewById(R.id.la3);
    pindah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LesArticlesActivity.this, lam3.class);
            startActivity(intent);
        }
    });}
}
