package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton ibtnEntre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibtnEntre = (ImageButton) findViewById(R.id.ibtn_entre);
        ibtnEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuAwalActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
