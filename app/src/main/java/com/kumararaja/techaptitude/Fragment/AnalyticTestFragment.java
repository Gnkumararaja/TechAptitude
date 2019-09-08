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

import com.kumararaja.techaptitude.Activity.QuestionSets;
import com.kumararaja.techaptitude.Adapter.AnalyticalAdapter;
import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.Activity.AnalyticalQuestions;
import com.kumararaja.techaptitude.R;

import java.util.ArrayList;
import java.util.List;

public class AnalyticTestFragment extends Fragment implements AnalyticalAdapter.OnADataListener {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;


    public AnalyticTestFragment() {
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

        data.add(new NumericModelData.Analytic("ANALOGY"));
        data.add(new NumericModelData.Analytic("CLASSIFICATION"));
        data.add(new NumericModelData.Analytic("CLOCKS"));
        data.add(new NumericModelData.Analytic("CUBES"));
        data.add(new NumericModelData.Analytic("DICE"));


        return data;
    }

    @Override
    public void dataClick(int position) {
        Log.v("CurrentPosition",""+position);
        Intent i =new Intent(getActivity(), QuestionSets.class);
        i.putExtra("Data",model().get(position));
        startActivity(i);

    }
}