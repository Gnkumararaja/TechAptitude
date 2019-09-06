package com.kumararaja.techaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.kumararaja.Model.NumericModelData;

public class VerbalQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_questions);
        Intent i=getIntent();
        NumericModelData.Verbal values=i.getParcelableExtra("Items");

        String v=values.getVerbalNames();
        getSupportActionBar().setTitle(v);

        Log.v("Success",""+v);
        Toast.makeText(this, ""+v, Toast.LENGTH_SHORT).show();
    }
}
