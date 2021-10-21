package com.buzzware.mood.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.activity.FoodItemDetailForFavoriteActivity;
import com.buzzware.mood.databinding.LayoutItemsFoodItems2Binding;


import java.util.List;


public class RecyclerViewAdapterFoodItemsFavorite extends RecyclerView.Adapter<RecyclerViewAdapterFoodItemsFavorite.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    public RecyclerViewAdapterFoodItemsFavorite(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsFoodItems2Binding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder : called.");

        if(i%4==0 || i%4==1){
            viewHolder.binding.fireCL.setVisibility(View.GONE);
        }
        viewHolder.binding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FoodItemDetailForFavoriteActivity.class);
                mContext.startActivity(intent);
                ((Activity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        if(i==0){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image1);
        }
        if(i==1){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image2);
        }
        if(i==2){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image3);
        }
        if(i==3){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image4);
        }
        if(i==4){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image5);
        }
        if(i==5){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image6);
        }
        if(i==6){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image7);
        }
        if(i==7){
            viewHolder.binding.mainIV.setImageResource(R.drawable.recycler_image8);
        }

    }

    @Override
    public int getItemCount() {
        int arr = 0;
        try{
            if(list.size()==0){
                arr = 0;
            }
            else{

                arr=list.size();
            }
        }catch (Exception e){
        }

        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsFoodItems2Binding binding;

        public ViewHolder(@NonNull LayoutItemsFoodItems2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
