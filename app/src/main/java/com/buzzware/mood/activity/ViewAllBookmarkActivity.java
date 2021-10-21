package com.buzzware.mood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterBookmark;
import com.buzzware.mood.adapter.RecyclerViewAdapterBookmarkViewAll;
import com.buzzware.mood.databinding.ActivityViewAllBookmarkBinding;

public class ViewAllBookmarkActivity extends AppCompatActivity {

    ActivityViewAllBookmarkBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewAllBookmarkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();
        setRecyclerView();
    }
    private void setView() {
        binding.includeView.titleTV.setText("Healthy Food");
        binding.includeView.backIV.setVisibility(View.VISIBLE);
        binding.includeView.backIV.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        binding.includeView.menuIV.setVisibility(View.VISIBLE);
        binding.includeView.menuIV.setImageDrawable(getResources().getDrawable(R.drawable.navigation_icon_pink));
    }
    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v -> {
            finish();
        });
        binding.includeView.menuIV.setOnClickListener(v -> {
            startActivity(new Intent(ViewAllBookmarkActivity.this,MapsActivity.class));
        });
    }
    private void setRecyclerView() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(ViewAllBookmarkActivity.this, LinearLayoutManager.VERTICAL,false);
        binding.mianRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterBookmarkViewAll adapter = new RecyclerViewAdapterBookmarkViewAll(ViewAllBookmarkActivity.this, null);
        binding.mianRV.setItemAnimator(new DefaultItemAnimator());
        binding.mianRV.setAdapter(adapter);
    }

}