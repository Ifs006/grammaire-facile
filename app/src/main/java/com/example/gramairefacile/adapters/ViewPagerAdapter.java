package com.example.gramairefacile.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.gramairefacile.activities.LesPronomMateriActivity;
import com.example.gramairefacile.fragments.MateriFragmentPronom;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(LesPronomMateriActivity fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 2) {
            return new OtherInfoFragment();
        } else {
            return MateriFragmentPronom.getInstance(position);
        }
    }

    @Override
    public int getCount() {
        return 18;
    }
}
