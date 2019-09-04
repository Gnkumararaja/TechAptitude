package com.kumararaja.techaptitude;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kumararaja.Adapter.NumericAdapter;
import com.kumararaja.Adapter.VerbalAdapter;
import com.kumararaja.Interface.NumericInterface;
import com.kumararaja.Model.NumericModelData;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerbalFragment extends Fragment implements VerbalAdapter.OnDataListener {

    Context context;
    RecyclerView recyclerView;
    NumericInterface onInterfce;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
  /*  String[] subjects =
            {
                    "ARITHMATIC",
                    "LOGIC",
                    "REASONING",
                    "MATHEMATICS",
                    "WORD PROBLEMS",
                    "BLOOD RELATIONS"
            };*/

    //Context context;



    public VerbalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_verbal, container, false);
        // Inflate the layout for this fragment
        recyclerView=v.findViewById(R.id.verbal_recycle);
        recylerViewLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter=new VerbalAdapter(model(),context,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        return v;
    }

    private List<NumericModelData.Verbal> model(){
        List<NumericModelData.Verbal> data = new ArrayList<>();

        data.add(new NumericModelData.Verbal("SPOTTING ERRORS", "IDOMS AND PHRASES", "ANONYMS", "SYNONYMS", "VOCABULARY"));

        return data;
    }

    @Override
    public void dataClick(int position) {

    }
}
