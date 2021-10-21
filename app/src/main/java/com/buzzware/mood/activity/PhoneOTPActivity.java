package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityPhoneOtpactivityBinding;

public class PhoneOTPActivity extends AppCompatActivity {


    ActivityPhoneOtpactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPhoneOtpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        setListener();

    }

    private void setListener() {
        binding.confirmBT.setOnClickListener(v->{
            startActivity(new Intent(PhoneOTPActivity.this,NickNameActivity.class));
        });
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Registration");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}