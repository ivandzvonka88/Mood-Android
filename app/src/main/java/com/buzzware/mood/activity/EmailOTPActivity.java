package com.buzzware.mood.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityEmailOtpactivityBinding;

public class EmailOTPActivity extends AppCompatActivity {

    ActivityEmailOtpactivityBinding binding;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmailOtpactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        getDataFromIntent();
        setListener();

    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
    }

    private void setListener() {
        binding.confirmBT.setOnClickListener(v->{
            if(type.equals("normal")){
                startActivity(new Intent(EmailOTPActivity.this,NickNameActivity.class));
            }else{
                startActivity(new Intent(EmailOTPActivity.this,NickNameActivity.class));
            }

        });
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Email Confirmation");
        binding.includeView.backIV.setImageResource(R.drawable.back_icon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}