package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.database.model.Conjonction;
import com.example.gramairefacile.database.model.Interrogatif;
import com.example.gramairefacile.utils.Constants;

public class MenuAwalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    private ImageButton ibtnLesVerbes;
    private ImageButton ibtnLesPronom;
    private ImageButton ibtnLesArticle;
    private ImageButton ibtnLesAdjectif;
    private ImageButton ibtnConjonction;
    private ImageButton ibtnInterogatif;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuawal);
        // Initialization database helper
        db = new DatabaseHelper(this);
        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ibtnLesVerbes = findViewById(R.id.ibtn_lesverbes);
        ibtnLesPronom = findViewById(R.id.ibtn_lespronom);
        ibtnLesArticle = findViewById(R.id.ibtn_lesarticles);
        ibtnLesAdjectif = findViewById(R.id.ibtn_lesadjectif);
        ibtnConjonction = findViewById(R.id.ibtn_lesconjonction);
        ibtnInterogatif = findViewById(R.id.ibtn_interogatif);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ibtnLesArticle.setOnClickListener(this);
        ibtnLesVerbes.setOnClickListener(this);
        ibtnLesPronom.setOnClickListener(this);
        ibtnLesAdjectif.setOnClickListener(this);
        ibtnConjonction.setOnClickListener(this);
        ibtnInterogatif.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.ibtn_lesverbes: {
                intent = new Intent(this, LesVerbesActivity.class);
                break;
            }
            case R.id.ibtn_lespronom: {
                intent = new Intent(this, LesPronomActivity.class);
                break;
            }
            case R.id.ibtn_lesarticles: {
                intent = new Intent(this, LesArticlesActivity.class);
                break;
            }
            case R.id.ibtn_lesadjectif: {
                intent = new Intent(this, LesAdjectifActivity.class);
                break;
            }
            case R.id.ibtn_lesconjonction: {
                intent = showDetail(Conjonction.class);
                break;
            }
            case R.id.ibtn_interogatif: {
                intent = showDetail(Interrogatif.class);
                break;
            }

        }

        if (intent != null)
            startActivity(intent);
    }

    private <T> Intent showDetail(Class<T> dataClass) {
        T data = db.getMateriByType(dataClass).get(0);

        Intent intent = new Intent(this, DetailMateriActivity.class);

        if (dataClass == Conjonction.class) {
            intent.putExtra(Constants.EXTRA_ID, ((Conjonction) data).getId());
            intent.putExtra(Constants.EXTRA_TITLE, ((Conjonction) data).getTitle());
            intent.putExtra(Constants.EXTRA_CONTENTS, ((Conjonction) data).getContents());
        } else {
            intent.putExtra(Constants.EXTRA_ID, ((Interrogatif) data).getId());
            intent.putExtra(Constants.EXTRA_TITLE, ((Interrogatif) data).getTitle());
            intent.putExtra(Constants.EXTRA_CONTENTS, ((Interrogatif) data).getContents());
        }

        return intent;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.credit) {
            Intent intent = new Intent(this, CreditActivity.class);
            startActivity(intent);
        } else if (id == R.id.a_propos_de_lauteur) {
            Intent intent = new Intent(this, AProposDeLauteurActivity.class);
            startActivity(intent);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
