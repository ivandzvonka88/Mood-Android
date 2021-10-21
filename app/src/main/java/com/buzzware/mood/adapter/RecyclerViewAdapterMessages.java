package com.buzzware.mood.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.LayoutItemsCommentsBinding;
import com.buzzware.mood.databinding.LayoutItemsMessageDialogListBinding;

import java.util.List;


public class RecyclerViewAdapterMessages extends RecyclerView.Adapter<RecyclerViewAdapterMessages.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;

    public RecyclerViewAdapterMessages(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsMessageDialogListBinding.inflate(LayoutInflater.from(parent.getContext()),
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

        viewHolder.binding.mainLayout.setOnClickListener(v->{
            if(viewHolder.binding.checkTV.getText().equals("0")){
                viewHolder.binding.checkMarkIV.setVisibility(View.VISIBLE);
                viewHolder.binding.checkTV.setText("1");
            }else{
                viewHolder.binding.checkMarkIV.setVisibility(View.INVISIBLE);
                viewHolder.binding.checkTV.setText("0");
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

        LayoutItemsMessageDialogListBinding binding;


        public ViewHolder(@NonNull LayoutItemsMessageDialogListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
