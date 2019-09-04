package com.kumararaja.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kumararaja.Interface.NumericInterface;
import com.kumararaja.techaptitude.R;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    String[] SubjectValues;
    Context context;
    private NumericInterface clickListener;
    View view1;
    NumericAdapter.ViewHolder viewHolder1;


    public TestAdapter(Context contextt, String[] subject) {
        this.SubjectValues = subject;
        this.context = contextt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.test_list_items, viewGroup, false);
        TestAdapter.ViewHolder viewHolder = new TestAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, final int position) {
        holder.txtView.setText(SubjectValues[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView, txtViewo, txtViewtwo;
        Context context;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtView = itemView.findViewById(R.id.text_easy);
            /*this.txtViewo = itemView.findViewById(R.id.text_normal);
            this.txtViewtwo =itemView.findViewById(R.id.text_hard);
*/

        }

    }
}
