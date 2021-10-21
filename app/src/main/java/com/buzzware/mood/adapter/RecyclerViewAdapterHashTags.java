package com.buzzware.mood.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.databinding.LayoutItemsFoodItems2Binding;
import com.buzzware.mood.databinding.LayoutItemsHashTagsBinding;

import java.util.List;


public class RecyclerViewAdapterHashTags extends RecyclerView.Adapter<RecyclerViewAdapterHashTags.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    public RecyclerViewAdapterHashTags(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsHashTagsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder : called.");

        LinearLayoutManager layoutManager5 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        viewHolder.binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItems3 adapter = new RecyclerViewAdapterFoodItems3(mContext, null);
        viewHolder.binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        viewHolder.binding.foodItemsRV.setAdapter(adapter);

        viewHolder.binding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, FoodItemDetailActivity.class);
//                mContext.startActivity(intent);
//                ((Activity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

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

        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsHashTagsBinding binding;


        public ViewHolder(@NonNull LayoutItemsHashTagsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
