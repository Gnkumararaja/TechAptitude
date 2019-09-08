package com.kumararaja.techaptitude.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kumararaja.techaptitude.Adapter.TestAdapter;
import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.R;

import java.util.ArrayList;
import java.util.List;


public class TesttypeActivity extends AppCompatActivity implements TestAdapter.OnTestDataListener {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtype);
        recyclerView=findViewById(R.id.test_recycle);
        recylerViewLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter=new TestAdapter(context,model(),this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }


    private List<NumericModelData.Taketest> model(){
        List<NumericModelData.Taketest> data = new ArrayList<>();

        data.add(new NumericModelData.Taketest("EASY"));
        data.add(new NumericModelData.Taketest("INTERMEDIATE"));
        data.add(new NumericModelData.Taketest("HARD"));

        return data;
    }

    @Override
    public void dataClick(int position) {
        Intent i = new Intent(this,CategoryTest.class);
        i.putExtra("Data_items",model().get(position));
        startActivity(i);
    }
}
