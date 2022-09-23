package com.example.projectversion_00.Common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectversion_00.R;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.locality.setText(datalist.get(position).getLocality());
        holder.weight.setText(String.valueOf(datalist.get(position).getWeight()));
        holder.desc.setText(datalist.get(position).getDesc());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView locality,weight,desc;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            locality=itemView.findViewById(R.id.locality);
            weight=itemView.findViewById(R.id.weight);
            desc=itemView.findViewById(R.id.desc);

        }
    }
}
