package com.example.gramairefacile.activities;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.adapters.LesArticlesAdapter;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.List;

public class LesArticlesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

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
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("LES ARTICLES");

        dataList = db.getMateriByType(LesArticles.class);
        lesArticlesAdapter = new LesArticlesAdapter(this, dataList);

        recyclerView.setAdapter(lesArticlesAdapter);
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
        LesArticles data = dataList.get(position);

        Intent intent = new Intent(this, DetailMateriActivity.class);
        intent.putExtra(Constants.EXTRA_ID, data.getId());
        intent.putExtra(Constants.EXTRA_TITLE, data.getTitle());
        intent.putExtra(Constants.EXTRA_CONTENTS, data.getContents());
        startActivity(intent);
    }
}
