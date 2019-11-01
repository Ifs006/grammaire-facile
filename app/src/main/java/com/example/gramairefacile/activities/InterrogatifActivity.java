package com.example.gramairefacile.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.Interrogatif;

import java.util.List;

public class InterrogatifActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleToolbar;
    private DatabaseHelper db;
    private List<Interrogatif> dataList;
    private ImageButton ibtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);

        db = new DatabaseHelper(this);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleToolbar = findViewById(R.id.title_toolbar);
        titleToolbar.setText("Interrogatif");
        titleToolbar.setGravity(Gravity.CENTER);

        ibtnBack = findViewById(R.id.btn_back);
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dataList = db.getMateriByType(Interrogatif.class);

    }

}


