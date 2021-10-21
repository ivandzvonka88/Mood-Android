package com.buzzware.mood.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.databinding.ActivityHashtagDetailBinding;

public class HashtagDetailActivity extends AppCompatActivity {
    ActivityHashtagDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityHashtagDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();
        initRecyclerViewFoodItems();

    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("#First hashtag");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }
    private void initRecyclerViewFoodItems() {
        GridLayoutManager layoutManager5 = new GridLayoutManager(HashtagDetailActivity.this, 3);
        binding.foodItemsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterFoodItems2 adapter = new RecyclerViewAdapterFoodItems2(HashtagDetailActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }
}