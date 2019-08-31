package com.example.gramairefacile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.gramairefacile.R;

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
    private ImageButton ibtnLesConjonction;
    private ImageButton ibtnInterogatif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuawal);

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ibtnLesVerbes = (ImageButton) findViewById(R.id.ibtn_lesverbes);
        ibtnLesPronom = (ImageButton) findViewById(R.id.ibtn_lespronom);
        ibtnLesArticle = (ImageButton) findViewById(R.id.ibtn_lesarticles);
        ibtnLesAdjectif = (ImageButton) findViewById(R.id.ibtn_lesadjectif);
        ibtnLesConjonction = (ImageButton) findViewById(R.id.ibtn_lesconjonction);
        ibtnInterogatif = (ImageButton) findViewById(R.id.ibtn_interogatif);

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
        ibtnLesConjonction.setOnClickListener(this);
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
                intent = new Intent(this, ConjonctionMateriActivity.class);
                break;
            }
            case R.id.ibtn_interogatif: {
                intent = new Intent(this, InterrogationMateriActivity.class);
                break;
            }

        }

        if (intent != null)
            startActivity(intent);
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
            // Handle the camera action
        } else if (id == R.id.a_propos_de_lauteur) {

        } else if (id == R.id.les_aides) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
