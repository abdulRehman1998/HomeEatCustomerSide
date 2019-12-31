package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.models.vendorModels.Vendor;
import com.example.myapplication.ui.Resturent_profile;

import java.util.ArrayList;
import java.util.List;


public class horizontalAdapter extends RecyclerView.Adapter<horizontalAdapter.MyViewHolder> {



    Context mContext;
    List<Vendor> vendorsList;
    LayoutInflater inflater;



    public horizontalAdapter(Context mContext, List<Vendor> vendorsList) {

        this.vendorsList=vendorsList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvAddress;
        TextView tvRating;
        LinearLayout linearLayout;

        public MyViewHolder(View view) {
            super(view);

                tvName=view.findViewById(R.id.vendorName_rl);
                tvAddress=view.findViewById(R.id.vendorAddress_rl);
                tvRating=view.findViewById(R.id.vendorRating_rl);
                linearLayout=view.findViewById(R.id.ll_resturent_layout);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resturent_layout, parent, false);


        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(final MyViewHolder holder, int position) {

                holder.tvName.setText(vendorsList.get(position).getName().toString());
                holder.tvAddress.setText(vendorsList.get(position).getAddress().toString());
                holder.tvRating.setText(String.valueOf(vendorsList.get(position).getRating()));






        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, Resturent_profile.class));



                    Intent intent = new Intent(mContext, Resturent_profile.class);
                   intent.putExtra("EXTRA_VENDOR",  vendorsList.get(position));
                    mContext.startActivity(intent);

                }
            });



    }



    @Override
    public int getItemCount() {
        return vendorsList.size();
    }


}
