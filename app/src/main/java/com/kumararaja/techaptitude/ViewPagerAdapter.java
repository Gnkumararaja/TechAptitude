package com.kumararaja.techaptitude;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mycontext;
    int totaltab;

    public ViewPagerAdapter(Context context,FragmentManager fm, int total) {
        super(fm);
        mycontext=context;
        totaltab=total;

    }



    @Override
    public Fragment getItem(int pos) {
        switch (pos){
            case 0:
                NumericFragment fragmentone=new NumericFragment();
                return fragmentone;
            case 1:
                VerbalFragment fragmenttwo = new VerbalFragment();
                return fragmenttwo;
            case 2:
                AnalyticFragment fragmentthree = new AnalyticFragment();
                return fragmentthree;
                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return totaltab;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position=position+1;

        return "Fragment"+position;

    }
}
