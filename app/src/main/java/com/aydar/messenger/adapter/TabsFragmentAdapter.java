package com.aydar.messenger.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

import com.aydar.messenger.AbstractTabFragment;
import com.aydar.messenger.MessengerFragment;
import com.aydar.messenger.FirstFragment;
import com.aydar.messenger.SecondFragment;
import com.aydar.messenger.ThirdFragment;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private SparseArray<AbstractTabFragment> tabs;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabsMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new SparseArray<>();
        tabs.put(0, FirstFragment.getInstance(context));
        tabs.put(1, SecondFragment.getInstance(context));
        tabs.put(2, ThirdFragment.getInstance(context));
        tabs.put(3, MessengerFragment.getInstance(context));
    }
}
