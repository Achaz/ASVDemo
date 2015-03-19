package com.asvdemo.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

public class PagesFragmentAdapter extends FragmentPagerAdapter{
    static String[] CONTENT = new String[] { "All", "Category 1", "Category 2", "Category 3", "Category 4"};

    private int mCount = CONTENT.length;

    public PagesFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    
    public PagesFragmentAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        PagesFragmentAdapter.CONTENT = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return new Page(CONTENT[position % CONTENT.length]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return PagesFragmentAdapter.CONTENT[position % CONTENT.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}