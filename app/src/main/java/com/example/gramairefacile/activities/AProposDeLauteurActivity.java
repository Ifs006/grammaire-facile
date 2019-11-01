package com.example.gramairefacile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gramairefacile.R;

public class AProposDeLauteurActivity extends AppCompatActivity {

    private ImageButton ibtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_propos_de_lauteur);

        initView();
    }

    private void initView() {
        ibtnBack = findViewById(R.id.btn_back);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
