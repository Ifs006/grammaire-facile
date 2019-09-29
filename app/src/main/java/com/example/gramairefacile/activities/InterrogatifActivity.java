package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.Interrogatif;
import com.example.gramairefacile.utils.Constants;

import java.util.List;

public class InterrogatifActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleToolbar;
    private DatabaseHelper db;
    private List<Interrogatif> dataList;

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
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("Interrogatif");

        dataList = db.getMateriByType(Interrogatif.class);

    }


    private void showDetail(int position) {
        Interrogatif data = dataList.get(position);

        Intent intent = new Intent(this, DetailMateriActivity.class);
        intent.putExtra(Constants.EXTRA_ID, data.getId());
        intent.putExtra(Constants.EXTRA_TITLE, data.getTitle());
        intent.putExtra(Constants.EXTRA_CONTENTS, data.getContents());
        startActivity(intent);
    }
}


