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
import com.kumararaja.techaptitude.Adapter.VerbalAdapter;
import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.R;
import com.kumararaja.techaptitude.Activity.VerbalQuestions;

import java.util.ArrayList;
import java.util.List;

public class VerbalTestFragment extends Fragment implements VerbalAdapter.OnDataListener {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;


    public VerbalTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_verbal, container, false);
        // Inflate the layout for this fragment
        recyclerView = v.findViewById(R.id.verbal_recycle);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new VerbalAdapter(model(), context, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
        return v;
    }

    private List<NumericModelData.Verbal> model() {
        List<NumericModelData.Verbal> data = new ArrayList<>();

        data.add(new NumericModelData.Verbal("Spotting Errors"));
        data.add(new NumericModelData.Verbal("Idoms and Phrases"));
        data.add(new NumericModelData.Verbal("Anonyms"));
        data.add(new NumericModelData.Verbal("Synonyms"));
        data.add(new NumericModelData.Verbal("Vocabulary"));

        return data;
    }

    @Override
    public void dataClick(int position) {
        Log.v("Clicked", "" + position);
        Intent i = new Intent(getActivity(), QuestionSets.class);
        i.putExtra("Items", model().get(position));
        startActivity(i);

    }
}
