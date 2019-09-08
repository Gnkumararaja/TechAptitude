package com.kumararaja.techaptitude.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.kumararaja.techaptitude.R;

public class QuestionSets extends AppCompatActivity {
    GridView gridView;
    String[] sets=new String[]{ "1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_sets);
        /*Intent i = getIntent();
        NumericModelData.Taketest values = i.getParcelableExtra("Data_items");

        String a = values.getTypes();
        getSupportActionBar().setTitle(a.toLowerCase() + " " + "Questions");*/
        gridView=findViewById(R.id.gridview);


    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adt=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,sets);
        gridView.setAdapter(adt);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QuestionSets.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
