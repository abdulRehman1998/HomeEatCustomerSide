package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class cuisineAdapter extends RecyclerView.Adapter<cuisineAdapter.ViewHolder> {

    String[] dataSet;
    Integer[] seasonsImgs;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView rv_desc;
        public ImageView rv_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_img=itemView.findViewById(R.id.rv_Image);
            rv_desc=itemView.findViewById(R.id.rv_desc);
        }
    }



    public cuisineAdapter(String[] dataSet,Integer[] seasonsImgs)
    {
        this.dataSet=dataSet;
        this.seasonsImgs=seasonsImgs;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder viewHolder =new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_view, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String desc=dataSet[position];
        TextView tv_desc=holder.rv_desc;
        ImageView rv_img=holder.rv_img;
        tv_desc.setText(desc);
        rv_img.setImageResource(seasonsImgs[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


}
