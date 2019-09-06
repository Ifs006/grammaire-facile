package com.example.gramairefacile.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.utils.Constants;

import java.util.List;

public class DetailMateriActivity extends AppCompatActivity {

    private int id;
    private String title;
    private List<Integer> contents;

    private Toolbar toolbar;
    private TextView titleToolbar;
    private LinearLayout contentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);

        readBundle();
        initViews();
    }

    private void readBundle(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt(Constants.EXTRA_ID, 0);
            title = bundle.getString(Constants.EXTRA_TITLE, "");

            String jsonList = bundle.getString(Constants.EXTRA_CONTENTS, "");
            contents = DatabaseHelper.toList(jsonList, Integer.class);
        }
    }

    private void initViews(){
        toolbar = findViewById(R.id.toolbar);
        titleToolbar = findViewById(R.id.title_toolbar);
        contentContainer = findViewById(R.id.content_container);

        titleToolbar.setText(title);

//        for (Integer content : contents) {
//            addContent(content);
//        }
    }

    private void addContent(int resource){
        View view = View.inflate(this, R.layout.view_materi, null);
        ImageView imageView = view.findViewById(R.id.img_content);

        Drawable dr = getResources().getDrawable(resource);
        int height = dr.getIntrinsicHeight();
        int width = dr.getIntrinsicWidth();

        imageView.getLayoutParams().height = height;
        imageView.setImageResource(resource);

        contentContainer.addView(view);

    }
}
