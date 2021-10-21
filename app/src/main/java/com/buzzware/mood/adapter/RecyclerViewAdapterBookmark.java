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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.ManageAccountActivity;
import com.buzzware.mood.activity.ViewAllBookmarkActivity;
import com.buzzware.mood.databinding.AlertDialogDeleteAccountBinding;
import com.buzzware.mood.databinding.AlertDialogDeleteBookmarkBinding;
import com.buzzware.mood.databinding.AlertDialogEditBookmarkNameBinding;
import com.buzzware.mood.databinding.BottomsheetDialogMessagesBinding;
import com.buzzware.mood.databinding.LayoutItemsBookmarkBinding;
import com.buzzware.mood.databinding.LayoutItemsHashTagsBinding;

import java.util.List;


public class RecyclerViewAdapterBookmark extends RecyclerView.Adapter<RecyclerViewAdapterBookmark.ViewHolder>  {

    private static final String TAG = "RCA_Categories";

    private List<String> list;
    private Context mContext;
    boolean check=false;
    Dialog dialog;

    public RecyclerViewAdapterBookmark(Context mContext, List<String> list,Boolean check) {
        this.list = list;
        this.mContext = mContext;
        this.check = check;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutItemsBookmarkBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder,int i) {
        Log.d(TAG, "onBindViewHolder : called.");

        viewHolder.binding.fireIV.setVisibility(View.INVISIBLE);
        if(check){
            viewHolder.binding.menuLL.setVisibility(View.VISIBLE);
            viewHolder.binding.viewsAll.setVisibility(View.INVISIBLE);
            viewHolder.binding.wrightArrow.setVisibility(View.INVISIBLE);
        }else{
            viewHolder.binding.menuLL.setVisibility(View.INVISIBLE);
            viewHolder.binding.viewsAll.setVisibility(View.VISIBLE);
            viewHolder.binding.wrightArrow.setVisibility(View.VISIBLE);
        }
        if(i==0){
            viewHolder.binding.hashTagTV.setText("Healthy Food(12)");

        }else if(i==1){
            viewHolder.binding.hashTagTV.setText("Sweets (4)");

        }else if(i==2){
            viewHolder.binding.hashTagTV.setText("Meat (10)");

        }else if(i==3){
            viewHolder.binding.hashTagTV.setText("Bakery (3)");

        }

        viewHolder.binding.editIV.setOnClickListener(v->{
            showDialogEditBookmark();
        });
        viewHolder.binding.deleteIV.setOnClickListener(v->{
            showDialogDeleteBookmark();
        });
        viewHolder.binding.messageIV.setOnClickListener(v->{
            showDialogMessages();
        });
        viewHolder.binding.shareIV.setOnClickListener(view -> {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://android-developers.googleblog.com/2021/07/05/introduing-android/html");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            mContext.startActivity(shareIntent);
        });
        viewHolder.binding.viewsAll.setOnClickListener(v->{
            mContext.startActivity(new Intent(mContext, ViewAllBookmarkActivity.class));
        });


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

        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LayoutItemsBookmarkBinding binding;


        public ViewHolder(@NonNull LayoutItemsBookmarkBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
    private void showDialogMessages() {
        Dialog dialog;
        dialog = new Dialog(mContext, android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final BottomsheetDialogMessagesBinding dialogBinding = BottomsheetDialogMessagesBinding.inflate(LayoutInflater.from(mContext));
        dialog.setContentView(dialogBinding.getRoot());
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        dialogBinding.messagesRV.setLayoutManager(layoutManager5);
        dialogBinding.messagesRV.setItemAnimator(new DefaultItemAnimator());
        dialogBinding.messagesRV.setAdapter(new RecyclerViewAdapterMessages(mContext, null));


        dialogBinding.closeTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialogBinding.doneTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialogBinding.sendBT.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();

    }

    private void showDialogEditBookmark() {

        dialog = new Dialog(mContext, R.style.Theme_AppCompat_Dialog_Alert);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final AlertDialogEditBookmarkNameBinding dialogBinding = AlertDialogEditBookmarkNameBinding.inflate(LayoutInflater.from(mContext));
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.cancelBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogBinding.saveBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
    private void showDialogDeleteBookmark() {

        dialog = new Dialog(mContext, R.style.Theme_AppCompat_Dialog_Alert);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final AlertDialogDeleteBookmarkBinding dialogBinding = AlertDialogDeleteBookmarkBinding.inflate(LayoutInflater.from(mContext));
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.yesBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialogBinding.noBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

}
