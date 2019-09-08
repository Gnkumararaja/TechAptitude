package com.kumararaja.techaptitude.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.kumararaja.techaptitude.Adapter.ViewPagerAdapter;
import com.kumararaja.techaptitude.R;

public class CategoryClass extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activitty);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Aptitude");

        tab = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.pager);

        tab.addTab(tab.newTab().setText("Numeric"));
        tab.addTab(tab.newTab().setText("Verbal"));
        tab.addTab(tab.newTab().setText("Analytical"));
        tab.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager(), tab.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
