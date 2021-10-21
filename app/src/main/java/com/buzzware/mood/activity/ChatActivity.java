package com.buzzware.mood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.buzzware.mood.adapter.RecyclerViewAdapterChatlist;
import com.buzzware.mood.adapter.RecyclerViewAdapterFoodItems2;
import com.buzzware.mood.adapter.RecyclerViewAdapterStories;
import com.buzzware.mood.databinding.ActivityChatBinding;
import com.buzzware.mood.databinding.ActivitySongInfoBinding;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setView();
        setListeners();
    }

    private void setListeners() {
        binding.includeView.backIV.setOnClickListener(view -> {
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Chats");
        initRecyclerViewStories();
        initRecyclerViewChatList();
    }

    private void initRecyclerViewStories() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.storiesRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterStories adapter = new RecyclerViewAdapterStories(this, null);
        binding.storiesRV.setItemAnimator(new DefaultItemAnimator());
        binding.storiesRV.setAdapter(adapter);
    }

    private void initRecyclerViewChatList() {
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.chatListRV.setLayoutManager(layoutManager5);

        RecyclerViewAdapterChatlist adapter = new RecyclerViewAdapterChatlist(this, null);
        binding.chatListRV.setItemAnimator(new DefaultItemAnimator());
        binding.chatListRV.setAdapter(adapter);
    }
}