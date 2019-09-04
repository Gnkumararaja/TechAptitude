package com.kumararaja.techaptitude;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kumararaja.Adapter.NumericAdapter;
import com.kumararaja.Interface.NumericInterface;
import com.kumararaja.Model.NumericModelData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyticFragment extends Fragment implements NumericAdapter.OnDataListener {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] subjects =
            {
                    "ARITHMATIC",
                    "LOGIC",
                    "REASONING",
                    "MATHEMATICS",
                    "WORD PROBLEMS",
                    "BLOOD RELATIONS"
            };


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
        recyclerViewAdapter=new NumericAdapter(model(), context,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        return v;
    }

    @Override
    public void dataClick(int position) {


    }

    private List<NumericModelData> model(){
        List<NumericModelData> data = new ArrayList<>();

        data.add(new NumericModelData("ARITHMATIC", "LOGIC", "REASONING", "MATHEMATICS", "WORD PROBLEMS", "BLOOD RELATIONS"));

        return data;
    }
}
