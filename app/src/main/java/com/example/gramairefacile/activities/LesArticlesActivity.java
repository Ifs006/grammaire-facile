package com.example.gramairefacile.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.adapters.LesArticlesAdapter;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.utils.ItemClickListener;

import java.util.List;

public class LesArticlesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;
    private ImageButton btnBack;

    private LesArticlesAdapter lesArticlesAdapter;
    private DatabaseHelper db;
    private List<LesArticles> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_articles);

        // Initialize database helper
        db = new DatabaseHelper(this);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView = findViewById(R.id.recyclerview);

        titleToolbar = findViewById(R.id.title_toolbar);
        titleToolbar.setText("Article");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dataList = db.getMateriByType(LesArticles.class);
        lesArticlesAdapter = new LesArticlesAdapter(this, dataList);

        recyclerView.setAdapter(lesArticlesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_article));
        recyclerView.addOnItemTouchListener(new ItemClickListener(this, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showDetail(position);
            }
        }));
    }


    private void showDetail(int position) {
        LesArticles data = dataList.get(position);

        Intent intent = new Intent(this, DetailMateriActivity.class);
        intent.putExtra(Constants.EXTRA_ID, data.getId());
        intent.putExtra(Constants.EXTRA_TITLE, data.getTitle());
        intent.putExtra(Constants.EXTRA_CONTENTS, data.getContents());
        intent.putExtra(Constants.EXTRA_BACKGROUND, R.drawable.bg_article);
        startActivity(intent);

    }
}
