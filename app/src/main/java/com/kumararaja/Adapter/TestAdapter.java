package com.kumararaja.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kumararaja.Model.NumericModelData;
import com.kumararaja.techaptitude.R;
import com.kumararaja.techaptitude.TesttypeActivity;

import java.util.Collections;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    List<NumericModelData.Taketest> list= Collections.emptyList();
    Context context;
    private OnTestDataListener dListener;


    public TestAdapter(Context contextt , List<NumericModelData.Taketest> list, OnTestDataListener onDataListener) {
        this.list = list;
        this.context = contextt;
        this.dListener=onDataListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.test_list_items, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(listItem,dListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, final int position) {
        holder.txtView.setText(list.get(position).getTypes());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView, txtViewo, txtViewtwo;
        Context context;
        OnTestDataListener dataListener;


        public ViewHolder(@NonNull View itemView,final OnTestDataListener dataListenerr) {
            super(itemView);

            this.txtView = itemView.findViewById(R.id.text_easy);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataListenerr.dataClick(getAdapterPosition());
                }
            });

        }



    }

    public interface OnTestDataListener{
        void dataClick(int position);
    }
}
