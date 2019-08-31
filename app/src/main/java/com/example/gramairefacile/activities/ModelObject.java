package com.example.gramairefacile.activities;

import com.example.gramairefacile.R;

public enum ModelObject {

    //    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.title_activity_les_pronom_materi, R.layout.list_materi_lespronom);
//    GREEN(R.string.green, R.layout.view_green);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}