package com.example.myapplication.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.ui.fragments.TabOne;
import com.example.myapplication.ui.fragments.TabThree;
import com.example.myapplication.ui.fragments.TabTwo;

public class PageAdapter extends FragmentStatePagerAdapter {

    int countTab;
    String state;

    public PageAdapter(FragmentManager fm, String state, int countTab) {
        super(fm);
        this.countTab = countTab;
        this.state = state;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabOne(state);
            case 1:
                return new TabTwo(state);
            case 2:
                return new TabThree(state);
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}
