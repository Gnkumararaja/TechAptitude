package com.kumararaja.techaptitude.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.R;

public class AnalyticalQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytical_questions);
        Intent intent=getIntent();
        NumericModelData.Analytic d = intent.getParcelableExtra("Data");

        String a = d.getNames();
        Toast.makeText(this, "Success"+a, Toast.LENGTH_SHORT).show();
        Log.d("Success",""+a);

    }
}
