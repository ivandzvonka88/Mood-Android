package com.buzzware.mood.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityReportProblemBinding;

public class ReportProblemActivity extends AppCompatActivity {

    ActivityReportProblemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReportProblemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setView();
        setListener();

    }

    private void setListener() {
        binding.reportBT.setOnClickListener(v -> {
            finish();
        });
        binding.includeView.backIV.setOnClickListener(v -> {
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Report a problem ");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}