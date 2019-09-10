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

import com.kumararaja.techaptitude.Adapter.AnalyticalAdapter;
import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.Activity.AnalyticalQuestions;
import com.kumararaja.techaptitude.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyticFragment extends Fragment implements AnalyticalAdapter.OnADataListener {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;


    public AnalyticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_analytic, container, false);
        // Inflate the layout for this fragment
        recyclerView=v.findViewById(R.id.analytic_recycle);
        recylerViewLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter=new AnalyticalAdapter(model(), context,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        return v;
    }



    private List<NumericModelData.Analytic> model(){
        List<NumericModelData.Analytic> data = new ArrayList<>();

        data.add(new NumericModelData.Analytic("Analogy"));
        data.add(new NumericModelData.Analytic("Classification"));
        data.add(new NumericModelData.Analytic("Clocks"));
        data.add(new NumericModelData.Analytic("Cubes"));
        data.add(new NumericModelData.Analytic("Dice"));


        return data;
    }

    @Override
    public void dataClick(int position) {
        Log.v("CurrentPosition",""+position);
        Intent i =new Intent(getActivity(), AnalyticalQuestions.class);
        i.putExtra("Data",model().get(position));
        startActivity(i);

    }
}
