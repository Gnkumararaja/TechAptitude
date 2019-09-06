package com.kumararaja.techaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kumararaja.Model.NumericModelData;

public class NumericQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeric_questions);

        Intent i=getIntent();
        NumericModelData values=i.getParcelableExtra("Item");

        String v=values.getNumericValues();
        Toast.makeText(this, "Clicked"+v, Toast.LENGTH_SHORT).show();
        Log.v("Success",""+v);

    }
}
