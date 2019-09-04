package com.kumararaja.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kumararaja.Model.NumericModelData;
import com.kumararaja.techaptitude.R;

import java.util.Collections;
import java.util.List;

public class VerbalAdapter extends RecyclerView.Adapter<VerbalAdapter.ViewHolder> {
    List<NumericModelData.Verbal> list= Collections.emptyList();
    Context context;
    private OnDataListener dListener;

    public VerbalAdapter(List<NumericModelData.Verbal> list,Context contextt, OnDataListener onDataListener) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtView.setText(list.get(position).getSpotting_errors());
        holder.txtViewo.setText(list.get(position).getIdoms_phrases());
        holder.txtViewtwo.setText(list.get(position).getAnonyms());
        holder.txtViewthree.setText(list.get(position).getSynonyms());
        holder.txtViewfour.setText(list.get(position).getVocabulary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView, txtViewo, txtViewtwo,txtViewthree,txtViewfour,txtfive;
        Context context;
        OnDataListener dataListener;


        public ViewHolder(@NonNull View itemView, final OnDataListener dataListenerr) {
            super(itemView);

            this.txtView = itemView.findViewById(R.id.arithmatic);
            this.txtViewo = itemView.findViewById(R.id.logic);
            this.txtViewtwo = itemView.findViewById(R.id.reasonn);
            this.txtViewthree = itemView.findViewById(R.id.maths);
            this.txtViewfour = itemView.findViewById(R.id.word);
            this.txtfive = itemView.findViewById(R.id.blood);
            this.dataListener = dataListenerr;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataListenerr.dataClick(getAdapterPosition());
                }
            });


        }


    }

    public interface OnDataListener{
        void dataClick(int position);
    }


}
