package com.kumararaja.techaptitude.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kumararaja.techaptitude.Fragment.AnalyticTestFragment;
import com.kumararaja.techaptitude.Fragment.NumericTestFragment;
import com.kumararaja.techaptitude.Fragment.VerbalTestFragment;

public class ViewPagerTest extends FragmentPagerAdapter {

    private Context mycontext;
    int totaltab;

    public ViewPagerTest(Context context, FragmentManager fm, int total) {
        super(fm);
        mycontext=context;
        totaltab=total;

    }



    @Override
    public Fragment getItem(int pos) {
        switch (pos){
            case 0:
                NumericTestFragment fragmentone=new NumericTestFragment();
                return fragmentone;
            case 1:
                VerbalTestFragment fragmenttwo = new VerbalTestFragment();
                return fragmenttwo;
            case 2:
                AnalyticTestFragment fragmentthree = new AnalyticTestFragment();
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
