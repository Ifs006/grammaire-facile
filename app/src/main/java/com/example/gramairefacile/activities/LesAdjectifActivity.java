package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.adapters.LesAdjectifAdapter;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.LesAdjectif;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.List;

public class LesAdjectifActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

    private LesAdjectifAdapter lesAdjectifAdapter;
    private DatabaseHelper db;
    private List<LesAdjectif> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_adjectif);

        db = new DatabaseHelper(this);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("LES ADJECTIFS");

        dataList = db.getMateriByType(LesAdjectif.class);
        lesAdjectifAdapter = new LesAdjectifAdapter(this, dataList);

        recyclerView.setAdapter(lesAdjectifAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.divider_dashed));
        recyclerView.addOnItemTouchListener(new ItemClickListener(this, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showDetail(position);
            }
        }));
    }

    private void showDetail(int position) {
        LesAdjectif data = dataList.get(position);

        Intent intent = new Intent(this, DetailMateriActivity.class);
        intent.putExtra(Constants.EXTRA_ID, data.getId());
        intent.putExtra(Constants.EXTRA_TITLE, data.getTitle());
        intent.putExtra(Constants.EXTRA_CONTENTS, data.getContents());
        startActivity(intent);
    }
}


