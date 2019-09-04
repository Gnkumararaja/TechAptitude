package com.kumararaja.techaptitude;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kumararaja.Adapter.NumericAdapter;
import com.kumararaja.Interface.NumericInterface;
import com.kumararaja.Model.NumericModelData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumericFragment extends Fragment implements NumericAdapter.OnDataListener {

    Context context;
    RecyclerView recyclerView;
    NumericInterface onInterfce;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
/*
    String[] subjects =
            {
                    "ARITHMATIC",
                    "LOGIC",
                    "REASONING",
                    "MATHEMATICS",
                    "WORD PROBLEMS",
                    "BLOOD RELATIONS"
            };*/

    //Context context;
  /*  private ArrayList<NumericModelData> model;*/


    public NumericFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_numeric, container, false);
        Log.v("LogData", "RecyclerViewone");

        recyclerView = v.findViewById(R.id.numeric_recycle);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new NumericAdapter(fill_data(),context, this);
        recyclerView.setAdapter(recyclerViewAdapter);

        Log.v("LogData", "RecyclerViewtwo");

        recyclerView.setHasFixedSize(true);


        return v;

    }

    @Override
    public void dataClick(int position) {
        Log.v("Click", "Clicked" + position);

    }

    private List<NumericModelData> fill_data() {

        List<NumericModelData> data = new ArrayList<>();

        data.add(new NumericModelData("ARITHMATIC", "LOGIC", "REASONING", "MATHEMATICS", "WORD PROBLEMS", "BLOOD RELATIONS"));

    return data;
    }

}
