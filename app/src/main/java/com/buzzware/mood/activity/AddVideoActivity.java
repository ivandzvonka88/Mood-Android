package com.buzzware.mood.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.buzzware.mood.R;
import com.buzzware.mood.databinding.ActivityAddVideoBinding;
import com.buzzware.mood.databinding.AlertDialogDurationBinding;
import com.buzzware.mood.databinding.AlertDialogFilterBinding;
import com.buzzware.mood.databinding.AlertDialogMusicBinding;
import com.buzzware.mood.databinding.AlertDialogSpeedBinding;
import com.buzzware.mood.databinding.AlertDialogTimerBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import eightbitlab.com.blurview.RenderScriptBlur;

public class AddVideoActivity extends AppCompatActivity {

    ActivityAddVideoBinding binding;
    BottomSheetDialog bottomSheetDialog;
    AlertDialogSpeedBinding alertDialogSpeedBinding;
    AlertDialogFilterBinding alertDialogFilterBinding;
    AlertDialogTimerBinding alertDialogTimerBinding;
    AlertDialogDurationBinding alertDialogDurationBinding;
    AlertDialogMusicBinding alertDialogMusicBinding;

    boolean music1Check = false;
    boolean music2Check = false;
    boolean music3Check = false;
    boolean music4Check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListener();

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

    private void setListener() {

        binding.speedIV.setOnClickListener(v -> {
            ShowSpeedDialog();
        });
        binding.filterIV.setOnClickListener(v -> {
            ShowFilterDialog();
        });
        binding.timerIV.setOnClickListener(v -> {
            ShowTimerDialog();
        });
        binding.durationIV.setOnClickListener(v -> {
            ShowDurationDialog();
        });
        binding.musicIV.setOnClickListener(v -> {
            ShowMusicDialog();
        });
        binding.cancelIV.setOnClickListener(v -> {
            finish();
        });
    }

    private void ShowSpeedDialog() {
        bottomSheetDialog = new BottomSheetDialog(AddVideoActivity.this, R.style.SheetDialog);
        alertDialogSpeedBinding = AlertDialogSpeedBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogSpeedBinding.getRoot());
        alertDialogSpeedBinding.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogSpeedBinding.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogSpeedBinding.tv1.setOnClickListener(v -> {
            alertDialogSpeedBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogSpeedBinding.tv1.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogSpeedBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogSpeedBinding.tv2.setOnClickListener(v -> {
            alertDialogSpeedBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogSpeedBinding.tv2.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogSpeedBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogSpeedBinding.tv3.setOnClickListener(v -> {
            alertDialogSpeedBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogSpeedBinding.tv3.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogSpeedBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogSpeedBinding.tv4.setOnClickListener(v -> {
            alertDialogSpeedBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogSpeedBinding.tv4.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogSpeedBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogSpeedBinding.tv5.setOnClickListener(v -> {
            alertDialogSpeedBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogSpeedBinding.tv5.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogSpeedBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogSpeedBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogSpeedBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

        });

        bottomSheetDialog.show();
    }

    private void ShowFilterDialog() {
        bottomSheetDialog = new BottomSheetDialog(AddVideoActivity.this, R.style.SheetDialog);
        alertDialogFilterBinding = AlertDialogFilterBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogFilterBinding.getRoot());
        alertDialogFilterBinding.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogFilterBinding.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogFilterBinding.filter1.filterIV.setImageDrawable(getResources().getDrawable(R.drawable.filter_image1));
        alertDialogFilterBinding.filter2.filterIV.setImageDrawable(getResources().getDrawable(R.drawable.filter_image2));
        alertDialogFilterBinding.filter3.filterIV.setImageDrawable(getResources().getDrawable(R.drawable.filter_image3));
        alertDialogFilterBinding.filter4.filterIV.setImageDrawable(getResources().getDrawable(R.drawable.filter_image4));
        alertDialogFilterBinding.filter5.filterIV.setImageDrawable(getResources().getDrawable(R.drawable.filter_image5));

        alertDialogFilterBinding.filter1.filterTV.setText("filter 1");
        alertDialogFilterBinding.filter2.filterTV.setText("filter 2");
        alertDialogFilterBinding.filter3.filterTV.setText("filter 3");
        alertDialogFilterBinding.filter4.filterTV.setText("filter 4");
        alertDialogFilterBinding.filter5.filterTV.setText("filter 5");

        alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.pink_300));

        alertDialogFilterBinding.filter1.mainCL.setOnClickListener(v->{
            alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogFilterBinding.filter2.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter3.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter4.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter5.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogFilterBinding.filter2.mainCL.setOnClickListener(v->{
            alertDialogFilterBinding.filter2.filterTV.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter3.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter4.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter5.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogFilterBinding.filter3.mainCL.setOnClickListener(v->{
            alertDialogFilterBinding.filter3.filterTV.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter2.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter4.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter5.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogFilterBinding.filter4.mainCL.setOnClickListener(v->{
            alertDialogFilterBinding.filter4.filterTV.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter2.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter3.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter5.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogFilterBinding.filter5.mainCL.setOnClickListener(v->{
            alertDialogFilterBinding.filter5.filterTV.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogFilterBinding.filter1.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter2.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter3.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogFilterBinding.filter4.filterTV.setTextColor(getResources().getColor(R.color.gray_100));
        });
        bottomSheetDialog.show();
    }

    private void ShowTimerDialog() {
        bottomSheetDialog = new BottomSheetDialog(AddVideoActivity.this, R.style.SheetDialog);
        alertDialogTimerBinding = AlertDialogTimerBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogTimerBinding.getRoot());
        alertDialogTimerBinding.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogTimerBinding.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });

        alertDialogTimerBinding.tv1.setOnClickListener(v -> {
            alertDialogTimerBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogTimerBinding.tv1.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogTimerBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogTimerBinding.tv2.setOnClickListener(v -> {
            alertDialogTimerBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogTimerBinding.tv2.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogTimerBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogTimerBinding.tv3.setOnClickListener(v -> {
            alertDialogTimerBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogTimerBinding.tv3.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogTimerBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogTimerBinding.tv4.setOnClickListener(v -> {
            alertDialogTimerBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogTimerBinding.tv4.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogTimerBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogTimerBinding.tv5.setOnClickListener(v -> {
            alertDialogTimerBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogTimerBinding.tv5.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogTimerBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogTimerBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogTimerBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

        });

        bottomSheetDialog.show();
    }

    private void ShowDurationDialog() {
        bottomSheetDialog = new BottomSheetDialog(AddVideoActivity.this, R.style.SheetDialog);
        alertDialogDurationBinding = AlertDialogDurationBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogDurationBinding.getRoot());
        alertDialogDurationBinding.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogDurationBinding.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });

        alertDialogDurationBinding.tv1.setOnClickListener(v -> {
            alertDialogDurationBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogDurationBinding.tv1.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogDurationBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogDurationBinding.tv2.setOnClickListener(v -> {
            alertDialogDurationBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogDurationBinding.tv2.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogDurationBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogDurationBinding.tv3.setOnClickListener(v -> {
            alertDialogDurationBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogDurationBinding.tv3.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogDurationBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogDurationBinding.tv4.setOnClickListener(v -> {
            alertDialogDurationBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogDurationBinding.tv4.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogDurationBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));

        });
        alertDialogDurationBinding.tv5.setOnClickListener(v -> {
            alertDialogDurationBinding.tv5.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
            alertDialogDurationBinding.tv5.setTextColor(getResources().getColor(R.color.pink_300));

            alertDialogDurationBinding.tv1.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv2.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv3.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));

            alertDialogDurationBinding.tv4.setBackground(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
            alertDialogDurationBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));

        });
        bottomSheetDialog.show();
    }

    private void ShowMusicDialog() {
        bottomSheetDialog = new BottomSheetDialog(AddVideoActivity.this, R.style.SheetDialog);
        alertDialogMusicBinding = AlertDialogMusicBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(alertDialogMusicBinding.getRoot());
        alertDialogMusicBinding.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        alertDialogMusicBinding.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });

        alertDialogMusicBinding.tv1.setOnClickListener(v->{
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv2.setOnClickListener(v->{
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv3.setOnClickListener(v->{
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv4.setOnClickListener(v->{
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv5.setOnClickListener(v->{
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv6.setOnClickListener(v->{
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.gray_100));
        });
        alertDialogMusicBinding.tv7.setOnClickListener(v->{
            alertDialogMusicBinding.tv7.setTextColor(getResources().getColor(R.color.pink_300));
            alertDialogMusicBinding.tv1.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv3.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv4.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv5.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv6.setTextColor(getResources().getColor(R.color.gray_100));
            alertDialogMusicBinding.tv2.setTextColor(getResources().getColor(R.color.gray_100));
        });






        alertDialogMusicBinding.music1.saveIV.setOnClickListener(v -> {
            if (music1Check) {
                alertDialogMusicBinding.music1.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
                alertDialogMusicBinding.music1.saveIV.setImageResource(R.drawable.save);
                music1Check = false;
            } else {
                alertDialogMusicBinding.music1.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
                alertDialogMusicBinding.music1.saveIV.setImageResource(R.drawable.pink_save_icon);
                music1Check = true;
            }

        });
        alertDialogMusicBinding.music2.saveIV.setOnClickListener(v -> {
            if (music2Check) {
                alertDialogMusicBinding.music2.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
                alertDialogMusicBinding.music2.saveIV.setImageResource(R.drawable.save);
                music2Check = false;
            } else {
                alertDialogMusicBinding.music2.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
                alertDialogMusicBinding.music2.saveIV.setImageResource(R.drawable.pink_save_icon);
                music2Check = true;
            }
        });
        alertDialogMusicBinding.music3.saveIV.setOnClickListener(v -> {
            if (music3Check) {
                alertDialogMusicBinding.music3.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
                alertDialogMusicBinding.music3.saveIV.setImageResource(R.drawable.save);
                music3Check = false;
            } else {
                alertDialogMusicBinding.music3.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
                alertDialogMusicBinding.music3.saveIV.setImageResource(R.drawable.pink_save_icon);
                music3Check = true;
            }
        });
        alertDialogMusicBinding.music4.saveIV.setOnClickListener(v -> {
            if (music4Check) {
                alertDialogMusicBinding.music4.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_white_stroke));
                alertDialogMusicBinding.music4.saveIV.setImageResource(R.drawable.save);
                music4Check = false;
            } else {
                alertDialogMusicBinding.music4.saveIV.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounder_corner_gray_pink_stroke));
                alertDialogMusicBinding.music4.saveIV.setImageResource(R.drawable.pink_save_icon);
                music4Check = true;
            }
        });

        alertDialogMusicBinding.music2.songIV.setImageResource(R.drawable.music_img_2);
        alertDialogMusicBinding.music3.songIV.setImageResource(R.drawable.music_img_3);
        alertDialogMusicBinding.music4.songIV.setImageResource(R.drawable.music_img_4);
        bottomSheetDialog.show();
    }

}