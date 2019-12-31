package com.example.myapplication.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Order;



public class cartItemsAdapter extends RecyclerView.Adapter<cartItemsAdapter.MyViewHolder> {


    Context mContext;
    Order mOrder;


    public cartItemsAdapter(Context mContext,  Order mOrder) {

        this.mOrder=mOrder;
        this.mContext = mContext;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPrcie;
        TextView tvQuantity;
        TextView tvDesc;


        public MyViewHolder(View view) {
            super(view);

            tvName=view.findViewById(R.id.tv_name_cartItemLayout);
            tvPrcie=view.findViewById(R.id.tv_price_cartItemLayout);
            tvQuantity=view.findViewById(R.id.tv_quantity_cartItemLayout);
            tvDesc=view.findViewById(R.id.tv_desc_cartItemLayout);

        }


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_layout, parent, false);
        return new MyViewHolder(itemView);
    }


    public void onBindViewHolder(final MyViewHolder holder, int position) {

    holder.tvName.setText(mOrder.getCartItemArrayList().get(position).getItem().getName());
    holder.tvPrcie.setText(String.valueOf(mOrder.getCartItemArrayList().get(position).getItem().getPrice()));
    holder.tvDesc.setText(mOrder.getCartItemArrayList().get(position).getItem().getDesc());
    holder.tvQuantity.setText(String.valueOf(mOrder.getCartItemArrayList().get(position).getQuantity()));

    }



    @Override
    public int getItemCount() {
        return mOrder.getCartItemArrayList().size();
    }






}
