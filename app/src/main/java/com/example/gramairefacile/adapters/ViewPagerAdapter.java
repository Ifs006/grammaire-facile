package com.example.gramairefacile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gramairefacile.activities.LesPronomMateriActivity;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(LesPronomMateriActivity fm) {
        super(fm.getSupportFragmentManager());
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 2) {
//            return new OtherInfoFragment();
        } else {
//            return MateriFragmentPronom.getInstance(position);
        }

        return null;
    }

    @Override
    public int getCount() {
        return 18;
    }
}
