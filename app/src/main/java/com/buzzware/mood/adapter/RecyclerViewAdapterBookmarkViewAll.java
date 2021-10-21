package com.buzzware.mood.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.ViewAllBookmarkActivity;
import com.buzzware.mood.databinding.AlertDialogDeleteBookmarkBinding;
import com.buzzware.mood.databinding.AlertDialogEditBookmarkNameBinding;
import com.buzzware.mood.databinding.LayoutItemsBookmarkBinding;
import com.buzzware.mood.databinding.LayoutItemsBookmarkViewAllBinding;

import java.util.List;


public class RecyclerViewAdapterBookmarkViewAll extends RecyclerView.Adapter<RecyclerViewAdapterBookmarkViewAll.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    Dialog dialog;

    public RecyclerViewAdapterBookmarkViewAll(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsBookmarkViewAllBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder,int i) {
        Log.d(TAG, "onBindViewHolder : called.");


        if(i==0){
            viewHolder.binding.titleTV.setText("Fruits");

        }else if(i==1){
            viewHolder.binding.titleTV.setText("Vegetables");

        }



        GridLayoutManager layoutManager5 = new GridLayoutManager(mContext, 2, GridLayoutManager.HORIZONTAL, false);
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

        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsBookmarkViewAllBinding binding;


        public ViewHolder(@NonNull LayoutItemsBookmarkViewAllBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
