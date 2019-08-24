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

        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ibtnLesArticle.setOnClickListener(this);
        ibtnLesVerbes.setOnClickListener(this);
        ibtnLesPronom.setOnClickListener(this);
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
            case R.id.ibtn_lesadjectif: {
                intent = new Intent(this, LesAdjectifActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuawal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
