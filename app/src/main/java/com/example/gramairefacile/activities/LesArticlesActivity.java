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
import com.example.gramairefacile.adapters.LesArticlesAdapter;
import com.example.gramairefacile.database.model.LesArticles;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class LesArticlesActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

    private LesArticlesAdapter lesArticlesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_articles);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("LES ARTICLES");

        List<LesArticles> lesArticles = new ArrayList<>();
//        lesArticles.add(new LesArticles(R.drawable.icon_lesarticles, "LES ARTICLES DÉFINIS"));
//        lesArticles.add(new LesArticles(R.drawable.icon_lesarticles, "LES ARTICLES INDÉFINIS"));
//        lesArticles.add(new LesArticles(R.drawable.icon_lesarticles, "LES ARTICLES PARTITIFS"));

        lesArticlesAdapter = new LesArticlesAdapter(this, lesArticles);

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

    public void showDetail(int position) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

}
