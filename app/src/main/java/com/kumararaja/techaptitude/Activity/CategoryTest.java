package com.kumararaja.techaptitude.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumararaja.techaptitude.Adapter.ViewPagerTest;
import com.kumararaja.techaptitude.R;

public class CategoryTest extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_test);

        tab = findViewById(R.id.testc_tablayout);
        viewPager = findViewById(R.id.testc_pager);

        tab.addTab(tab.newTab().setText("Numeric"));
        tab.addTab(tab.newTab().setText("Verbal"));
        tab.addTab(tab.newTab().setText("Analytical"));
        tab.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPagerTest adapter = new ViewPagerTest(this, getSupportFragmentManager(), tab.getTabCount());
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
