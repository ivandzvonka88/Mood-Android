package com.buzzware.mood.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.databinding.ActivityOtherUserProfileBinding;

public class OtherUserProfileActivity extends AppCompatActivity {

    ActivityOtherUserProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtherUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SetView();
        SetListeners();
        initRecyclerViewFoodItems();
    }

    private void SetListeners() {
     binding.includeView.backIV.setOnClickListener(v->{
         finish();
     });
        binding.myVideoLL.setOnClickListener(v->{
            binding.myVideoTV.setTextColor(getResources().getColor(R.color.pink_300));
            ImageViewCompat.setImageTintList(binding.myVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.pink_300)));
            binding.likeVideoTV.setTextColor(getResources().getColor(R.color.gray_200));
            ImageViewCompat.setImageTintList(binding.likeVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.gray_200)));
        });
        binding.myVideoLL.setOnClickListener(v->{
            binding.myVideoTV.setTextColor(getResources().getColor(R.color.gray_200));
            ImageViewCompat.setImageTintList(binding.myVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.gray_200)));
            binding.likeVideoTV.setTextColor(getResources().getColor(R.color.pink_300));
            ImageViewCompat.setImageTintList(binding.likeVideoIV, ColorStateList.valueOf(getResources().getColor(R.color.pink_300)));
        });
    }
    private void SetView() {
        binding.includeView.titleTV.setText("Dick Moriarty");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(OtherUserProfileActivity.this, 3);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItems2 adapter = new RecyclerViewAdapterFoodItems2(OtherUserProfileActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
}