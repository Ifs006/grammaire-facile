package com.example.gramairefacile;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class lvm1 extends AppCompatActivity {
    ImageButton pindah;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvm1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        teks = (TextView) findViewById(R.id.VerbeRegulierre);
        Typeface customfont=Typeface.createFromAsset(getAssets(),"font/Warung Kopi.otf");
        teks.setTypeface(customfont);


};
}
