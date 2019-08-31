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
import com.example.gramairefacile.adapters.LesVerbesAdapter;
import com.example.gramairefacile.database.model.LesVerbes;
import com.example.gramairefacile.utils.ItemClickListener;
import com.example.gramairefacile.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class LesVerbesActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TextView titleToolbar;
    private RecyclerView recyclerView;

    private LesVerbesAdapter lesVerbesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_verbes);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        titleToolbar = findViewById(R.id.title_toolbar);

        titleToolbar.setText("Les Verbes");

        List<LesVerbes> lesVerbes = new ArrayList<>();
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "Le Verbe Reguliere"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "Le Verbe Irreguliere"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "Le Conditionnel De Politesse"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "La Negation"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "La Forme Impersonnel Simple"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "L'Imperatif"));
        lesVerbes.add(new LesVerbes(R.mipmap.ic_launcher, "Present De L'Indication"));

        lesVerbesAdapter = new LesVerbesAdapter(this, lesVerbes);

        recyclerView.setAdapter(lesVerbesAdapter);
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

    private void showDetail(int position){
        Intent intent = new Intent(this, LesVerbesMateriActivity.class);
        startActivity(intent);
    }
}