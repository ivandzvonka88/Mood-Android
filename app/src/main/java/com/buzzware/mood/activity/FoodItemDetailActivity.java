package com.buzzware.mood.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.buzzware.mood.R;
import com.buzzware.mood.adapter.FoodItemDetailAdapter;
import com.buzzware.mood.adapter.RecyclerViewAdapterComments;
import com.buzzware.mood.databinding.ActivityFoodItemDetailBinding;
import com.buzzware.mood.databinding.AlertDialogSaveBookmarkBinding;
import com.buzzware.mood.databinding.BottomsheetDialogCommentsBinding;
import com.buzzware.mood.databinding.BottomsheetDialogLocationBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import eightbitlab.com.blurview.RenderScriptBlur;

public class FoodItemDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ActivityFoodItemDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodItemDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setListener();
        initRecyclerViewFoodItems();

//        binding.viewPager.canScrollHorizontally(1);
        //   SetSlider();

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
        binding.commentIV.setOnClickListener(view -> {
            showBottomSheetDialog();
        });
        binding.backIV.setOnClickListener(v -> {
            finish();
        });

        binding.shareIV.setOnClickListener(view -> {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://android-developers.googleblog.com/2021/07/05/introduing-android/html");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        binding.musicIV.setOnClickListener(view -> {
            Intent intent = new Intent(FoodItemDetailActivity.this, SongInfoActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        binding.locationIV.setOnClickListener(view -> {
            showBottomSheetDialogLocation();
        });
        binding.bookmarkIV.setOnClickListener(v -> {
            showBottomSheetDialogSaveBookmarks();
        });

    }

    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.SheetDialog);
        final BottomsheetDialogCommentsBinding binding1 = BottomsheetDialogCommentsBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding1.getRoot());

        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding1.recyclerViewComments.setLayoutManager(layoutManager5);
        binding1.recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        binding1.recyclerViewComments.setAdapter(new RecyclerViewAdapterComments(this, null));
        binding1.closeTV.setOnClickListener(view -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }

    private void showBottomSheetDialogSaveBookmarks() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.SheetDialog);
        final AlertDialogSaveBookmarkBinding binding1 = AlertDialogSaveBookmarkBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding1.getRoot());
        binding1.applyTV.setOnClickListener(view -> {
            bottomSheetDialog.dismiss();
        });
        binding1.closeTV.setOnClickListener(view -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();
    }

    private void showBottomSheetDialogLocation() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.SheetDialog);
        final BottomsheetDialogLocationBinding binding2 = BottomsheetDialogLocationBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding2.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bottomSheetDialog.show();
    }

    private void initRecyclerViewFoodItems() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FoodItemDetailActivity.this);
        binding.foodItemsRV.setLayoutManager(linearLayoutManager);

        FoodItemDetailAdapter adapter = new FoodItemDetailAdapter(FoodItemDetailActivity.this, null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
    }

//    public void SetSlider()
//    {
//        ///imageSlider start
//
//        ImageSliderViewPagerAdapter viewPagerAdapter = new ImageSliderViewPagerAdapter(this, null);
//        binding.viewPager.setAdapter(viewPagerAdapter);
//
//        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
//
//        ///end image slider
//    }
}