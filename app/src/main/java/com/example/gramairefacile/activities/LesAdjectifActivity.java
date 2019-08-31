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
import com.example.gramairefacile.database.model.LesAdjectif;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class LesAdjectifActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

    private LesAdjectifAdapter lesAdjectifAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_adjectif);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("LES ADJECTIFS");

        List<LesAdjectif> lesAdjectif = new ArrayList<>();
        lesAdjectif.add(new LesAdjectif(R.drawable.icon_lesadjectif, "L’ADJECTIFS POSSESSIF"));
        lesAdjectif.add(new LesAdjectif(R.drawable.icon_lesadjectif, "L’ADJECTIFS DÉMONSTRATIF"));
        lesAdjectif.add(new LesAdjectif(R.drawable.icon_lesadjectif, "L’ADJECTIFS QUALIFICATIFS"));

        lesAdjectifAdapter = new LesAdjectifAdapter(this, lesAdjectif);

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

    public void showDetail(int position) {
        Intent intent = new Intent(this, LesAdjectifMateriActivity.class);
        startActivity(intent);
    }


}


