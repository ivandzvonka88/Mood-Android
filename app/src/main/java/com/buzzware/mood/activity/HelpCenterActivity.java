package com.buzzware.mood.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityHelpCenterBinding;

public class HelpCenterActivity extends AppCompatActivity {

    ActivityHelpCenterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelpCenterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();
    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Help Center");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}