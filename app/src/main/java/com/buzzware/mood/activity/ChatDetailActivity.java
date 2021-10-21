package com.buzzware.mood.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.buzzware.mood.databinding.ActivityChatBinding;
import com.buzzware.mood.databinding.ActivityChatDetailBinding;

import eightbitlab.com.blurview.RenderScriptBlur;

public class ChatDetailActivity extends AppCompatActivity {

    ActivityChatDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setView();
        setListeners();

        float radius = 20f;

        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        binding.blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);
    }

    private void setListeners() {
        binding.includeView.backIV.setOnClickListener(view -> {
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("@sara.klipovska");
    }
}