package com.example.gramairefacile.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.adapters.LesPronomAdapter;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.LesPronom;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.List;

public class LesPronomActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

    private LesPronomAdapter lesPronomsAdapter;
    private DatabaseHelper db;
    private List<LesPronom> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_pronom);

        // Initialize database helper
        db = new DatabaseHelper(this);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("LES PRONOMS");


        dataList = db.getMateriByType(LesPronom.class);
        lesPronomsAdapter = new LesPronomAdapter(this, dataList);

        recyclerView.setAdapter(lesPronomsAdapter);
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
        LesPronom data = dataList.get(position);

        Intent intent = new Intent(this, DetailMateriActivity.class);
        intent.putExtra(Constants.EXTRA_ID, data.getId());
        intent.putExtra(Constants.EXTRA_TITLE, data.getTitle());
        intent.putExtra(Constants.EXTRA_CONTENTS, data.getContents());
        startActivity(intent);
    }
}