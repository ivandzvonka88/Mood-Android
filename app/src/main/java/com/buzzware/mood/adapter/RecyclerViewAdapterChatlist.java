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
import com.buzzware.mood.activity.ChatDetailActivity;
import com.buzzware.mood.databinding.LayoutItemsChatListBinding;
import com.buzzware.mood.databinding.LayoutItemsCommentsBinding;

import java.util.List;


public class RecyclerViewAdapterChatlist extends RecyclerView.Adapter<RecyclerViewAdapterChatlist.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    public RecyclerViewAdapterChatlist(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsChatListBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder : called.");

        if(i%3==1){
            viewHolder.binding.profileIV.setImageResource(R.drawable.profile_pic2);
        }
        if(i%3==0){
            viewHolder.binding.profileIV.setImageResource(R.drawable.profile_picture);
        }

        viewHolder.binding.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ChatDetailActivity.class);
                mContext.startActivity(intent);
                ((Activity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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

        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsChatListBinding binding;


        public ViewHolder(@NonNull LayoutItemsChatListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
