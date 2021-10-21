package com.buzzware.mood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterBookmark;
import com.buzzware.mood.databinding.ActivityBookMarkBinding;

public class BookMarkActivity extends AppCompatActivity {

    ActivityBookMarkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookMarkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();
        setRecyclerView(false);

    }
    private void setView() {
        binding.includeView.titleTV.setText("Bookmarks");
        binding.includeView.backIV.setVisibility(View.VISIBLE);
        binding.includeView.backIV.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        binding.includeView.menuIV.setVisibility(View.INVISIBLE);

    }
    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
        binding.mainMenuIV.setOnClickListener(v->{
            binding.mainMenuIV.setVisibility(View.INVISIBLE);
            binding.markIV.setVisibility(View.VISIBLE);
            binding.searchBtn.setVisibility(View.GONE);
            binding.searchET.setVisibility(View.GONE);
            setRecyclerView(true);
        });
        binding.markIV.setOnClickListener(v->{
            binding.mainMenuIV.setVisibility(View.VISIBLE);
            binding.markIV.setVisibility(View.INVISIBLE);
            binding.searchBtn.setVisibility(View.VISIBLE);
            binding.searchET.setVisibility(View.VISIBLE);
            setRecyclerView(false);
        });
    }
    private void setRecyclerView(Boolean check) {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(BookMarkActivity.this, LinearLayoutManager.VERTICAL, false);
        binding.hashTagsRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterBookmark adapter = new RecyclerViewAdapterBookmark(BookMarkActivity.this, null,check);
        binding.hashTagsRV.setItemAnimator(new DefaultItemAnimator());
        binding.hashTagsRV.setAdapter(adapter);
    }



}