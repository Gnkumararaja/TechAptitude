package com.kumararaja.techaptitude.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumararaja.techaptitude.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
    }
}
