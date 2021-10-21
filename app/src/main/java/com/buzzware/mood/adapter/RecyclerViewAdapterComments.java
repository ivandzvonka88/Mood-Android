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

import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.databinding.LayoutItemsCommentsBinding;
import com.buzzware.mood.databinding.LayoutItemsFoodItemsBinding;

import java.util.List;


public class RecyclerViewAdapterComments extends RecyclerView.Adapter<RecyclerViewAdapterComments.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    public RecyclerViewAdapterComments(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsCommentsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder : called.");

//        viewHolder.binding.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, FoodItemDetailActivity.class);
//                mContext.startActivity(intent);
//                ((Activity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//            }
//        });

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

        LayoutItemsCommentsBinding binding;


        public ViewHolder(@NonNull LayoutItemsCommentsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
