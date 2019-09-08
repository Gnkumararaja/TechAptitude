package com.kumararaja.techaptitude.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kumararaja.techaptitude.Adapter.NumericAdapter;
import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.Activity.NumericQuestions;
import com.kumararaja.techaptitude.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumericFragment extends Fragment implements NumericAdapter.OnDataListener {

    Context context;
    RecyclerView recyclerView;
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
        Intent i = new Intent(getActivity(), NumericQuestions.class);
        i.putExtra("Item",fill_data().get(position));
        startActivity(i);

    }

    private List<NumericModelData> fill_data() {

        List<NumericModelData> data = new ArrayList<>();

        data.add(new NumericModelData("ARITHMATIC" ));
        data.add(new NumericModelData("LOGIC"));
        data.add(new NumericModelData("REASONING"));
        data.add(new NumericModelData("MATHEMATICS"));
        data.add(new NumericModelData("WORD PROBLEMS"));
        data.add(new NumericModelData("BLOOD RELATIONS"));

    return data;
    }

}
