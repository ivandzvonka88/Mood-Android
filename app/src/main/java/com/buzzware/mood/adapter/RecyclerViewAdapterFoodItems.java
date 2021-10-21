package com.buzzware.mood.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.buzzware.mood.R;
import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.activity.MainActivity;
import com.buzzware.mood.databinding.LayoutItemsFoodItemsBinding;

import java.util.List;


public class RecyclerViewAdapterFoodItems extends RecyclerView.Adapter<RecyclerViewAdapterFoodItems.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;
    ClickListener clickListener;

    public RecyclerViewAdapterFoodItems(Context mContext, List<String> list, ClickListener clickListener) {
        this.list = list;
        this.mContext = mContext;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsFoodItemsBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder : called.");

        if(i%3==0 || i%3==1){
            viewHolder.binding.fireCL.setVisibility(View.GONE);
        }else{
            viewHolder.binding.fireCL.setVisibility(View.VISIBLE);

        }
        viewHolder.binding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick();
//                Intent intent = new Intent(mContext, FoodItemDetailActivity.class);
//                mContext.startActivity(intent);
//                ((Activity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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

        return 8;
    }

    public interface ClickListener{
        void OnClick();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsFoodItemsBinding binding;


        public ViewHolder(@NonNull LayoutItemsFoodItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
