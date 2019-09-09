package com.example.gramairefacile.activities;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.utils.Constants;

public class DetailMateriActivity extends AppCompatActivity {

    private int id;
    private String title;
    private int[] contents;

    private Toolbar toolbar;
    private TextView titleToolbar;
    private LinearLayout contentContainer;
    private ImageButton ibtnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);

        readBundles();
        initViews();
    }

    private void readBundles() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt(Constants.EXTRA_ID, 0);
            title = bundle.getString(Constants.EXTRA_TITLE, "");

            String jsonList = bundle.getString(Constants.EXTRA_CONTENTS, "");
            contents = DatabaseHelper.toArray(jsonList, int[].class);
        }
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        titleToolbar = findViewById(R.id.title_toolbar);
        contentContainer = findViewById(R.id.content_container);
        ibtnQuiz = findViewById(R.id.ibtn_quiz);

        titleToolbar.setText(title);

        for (Integer content : contents) {
            addContent(content);
        }

        ibtnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailMateriActivity.this, QuizActivity.class)
                        .putExtra(Constants.EXTRA_ID_MATERI, id));
            }
        });
    }

    private void addContent(int resource) {
        BitmapDrawable bd = (BitmapDrawable) getResources().getDrawable(resource);
        int imageHeight = bd.getIntrinsicHeight();

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, imageHeight));
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(resource);

        contentContainer.addView(imageView);

    }
}
