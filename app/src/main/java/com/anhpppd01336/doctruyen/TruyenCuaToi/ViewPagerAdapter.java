package com.anhpppd01336.doctruyen.TruyenCuaToi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Anh Pham on 27/10/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabtitles[] = new String[]{"Truyện Online", "Truyện Offline"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TruyenOnlineFragment();
            case 1:
                return new TruyenOfflineFragment();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
