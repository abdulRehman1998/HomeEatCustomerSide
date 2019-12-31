package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;



public class resturentsReviewsAdapter extends RecyclerView.Adapter<resturentsReviewsAdapter.MyViewHolder> {



    Context mContext;
    LayoutInflater inflater;

    public resturentsReviewsAdapter(Context mContext) {

        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        /*   TextView videoName;
           ImageView imageView;
   */
        public MyViewHolder(View view) {
            super(view);
      /*      videoName=(TextView)view.findViewById(R.id.videoText) ;
            imageView = (ImageView) view.findViewById(R.id.imgVideo);
*/
        }


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reviews_layout, parent, false);
        return new MyViewHolder(itemView);
    }


    public void onBindViewHolder(final MyViewHolder holder, int position) {
 /*       holder.videoName.setText("Name");
        Drawable draw = holder.imageView.getResources().getDrawable(images[position]);
        holder.imageView.setImageDrawable(draw);
 */   }



    @Override
    public int getItemCount() {
        return 10;
    }


}
