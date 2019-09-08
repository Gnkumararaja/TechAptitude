package com.kumararaja.techaptitude.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kumararaja.techaptitude.Model.NumericModelData;
import com.kumararaja.techaptitude.R;

import java.util.Collections;
import java.util.List;

public class AnalyticalAdapter extends RecyclerView.Adapter<AnalyticalAdapter.ViewHolder> {

    List<NumericModelData.Analytic> list= Collections.emptyList();
    Context context;
    private OnADataListener dListener;

    public AnalyticalAdapter(List<NumericModelData.Analytic> list,Context contextt, OnADataListener onDataListener) {
        this.list = list;
        this.context = contextt;
        this.dListener=onDataListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.activity_numeric_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem,dListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnalyticalAdapter.ViewHolder holder, int position) {
        holder.txtView.setText(list.get(position).getNames());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView, txtViewo, txtViewtwo,txtViewthree,txtViewfour,txtfive;
        Context context;
        OnADataListener dataListener;


        public ViewHolder(@NonNull View itemView, final OnADataListener dataListenerr) {
            super(itemView);

            this.txtView = itemView.findViewById(R.id.arithmatic);
            this.dataListener = dataListenerr;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataListenerr.dataClick(getAdapterPosition());
                }
            });


        }


    }

    public interface OnADataListener{
        void dataClick(int position);
    }


}
