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
import com.example.myapplication.models.CartItem;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.Order;


public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.MyViewHolder> {



    Context mContext;
    LayoutInflater inflater;
    Category category;
    Dialog mDialog;

    TextView tvCounterDialog;
    ImageView dialogPlus;
    ImageView dialogMinus;
    Button btnAdd;
    Button btnCancel;
    Order mOrder;

    Activity mActivity;
    int count;

    public itemsAdapter(Context mContext, Category category, Activity mActivity, Order mOrder) {

        this.mOrder=mOrder;
        this.mActivity=mActivity;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
        this.category = category;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderCount ;
        ImageView imgOrderCount;
        LinearLayout llItemLayout;
        TextView tvName;
        TextView tvDesc;
        TextView tvPrice;

        public MyViewHolder(View view) {
            super(view);

            tvOrderCount=view.findViewById(R.id.orderCountTextIl);
            imgOrderCount=view.findViewById(R.id.orderCountCirleIl);
            llItemLayout=view.findViewById(R.id.layout_item);
            tvName=view.findViewById(R.id.tv_name_itemLayout);
            tvDesc=view.findViewById(R.id.tv_desc_itemLayout);
            tvPrice=view.findViewById(R.id.tv_price_itemLayout);


        }


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(itemView);
    }


    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.tvName.setText(category.getItems().get(position).getName());
        holder.tvDesc.setText(category.getItems().get(position).getDesc());
        holder.tvPrice.setText(String.valueOf(category.getItems().get(position).getPrice()));



        holder.llItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addDialog(position);



                /*int count= Integer.parseInt(holder.tvOrderCount.getText().toString());
                count++;
                if(count>0)
                {
                    holder.imgOrderCount.setBackgroundResource(R.drawable.circle_colored);
                }
                holder.tvOrderCount.setText(String.valueOf(count));
*/

            }
        });


    }



    @Override
    public int getItemCount() {
       return category.getItems().size();
    }



    void addDialog(int position)
    {
        Rect displayRectangle = new Rect();
        Window window = mActivity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width=(int)(displayRectangle.width() * 0.9f);
        lp.height=(int)(displayRectangle.height() * 0.5f);

        mDialog = new Dialog(mContext);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.setContentView(R.layout.order_count_dialoge);
        mDialog.getWindow().setAttributes(lp);

        mDialog.show();

        tvCounterDialog=mDialog.findViewById(R.id.tvCounter_dialog);
        tvCounterDialog.setText("0");
        dialogPlus=mDialog.findViewById(R.id.imgPlus_dialog);
        dialogMinus=mDialog.findViewById(R.id.imgMinus_dialog);
        btnAdd=mDialog.findViewById(R.id.btnAdd_dialog);
        btnCancel=mDialog.findViewById(R.id.btnCancel_dialog);

        dialogPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count= Integer.parseInt(tvCounterDialog.getText().toString());
                count++;
                tvCounterDialog.setText(String.valueOf(count));

            }
        });
        dialogMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count= Integer.parseInt(tvCounterDialog.getText().toString());
                if(count==0)
                {

                }
                 else {
                     count--;
                }
                tvCounterDialog.setText(String.valueOf(count));

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count>0)
                {
                    CartItem cartItem=new CartItem(category.getItems().get(position).get_id(), category.getItems().get(position),count);
                    mOrder.addCartItem(cartItem);
                    mOrder.addPrice(category.getItems().get(position).getPrice());
                    Toast.makeText(mContext,"Added to cart",Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }
                else
                {
                    Toast.makeText(mContext,"Please enter Some quantity",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
