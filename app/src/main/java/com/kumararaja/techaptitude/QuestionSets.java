package com.kumararaja.techaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumararaja.Model.NumericModelData;

public class QuestionSets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_sets);

        Intent i = getIntent();
        NumericModelData.Taketest values=i.getParcelableExtra("Data_items");

        String a = values.getTypes();


        getSupportActionBar().setTitle(a.toLowerCase()+" "+"Questions");
    }
}
