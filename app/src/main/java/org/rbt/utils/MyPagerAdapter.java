package org.rbt.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.rbt.fragments.FragmentOne;
import org.rbt.fragments.FragmentThree;
import org.rbt.fragments.FragmentTwo;

/**
 * Created by saikrishna.pawar on 31/03/16.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private static int NUM_ITEMS = 3;
    private float alphaValue;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FragmentOne.newInstance(getAlphaValue());//passing the alpha value to each fragment
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FragmentTwo.newInstance(getAlphaValue());//passing the alpha value to each fragment
            case 2: // Fragment # 1 - This will show SecondFragment
                return FragmentThree.newInstance(getAlphaValue());//passing the alpha value to each fragment
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

    public float getAlphaValue() {
        return alphaValue;
    }

    public void setAlphaValue(float alphaValue) {
        this.alphaValue = alphaValue;
    }
}
