package com.kumararaja.techaptitude;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kumararaja.Adapter.TestAdapter;


public class TesttypeActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
   // NumericInterface onInterfce;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] subjects =
            {
                    "EASY",
                    "INTERMEDIATE",
                    "ADVANCED"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtype);
        recyclerView=findViewById(R.id.test_recycle);
        recylerViewLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter=new TestAdapter(context,subjects);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
