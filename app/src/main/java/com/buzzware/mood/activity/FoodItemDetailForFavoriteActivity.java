package com.buzzware.mood.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.RecyclerViewAdapterComments;
import com.buzzware.mood.databinding.ActivityFoodItemDetailForFavoriteBinding;
import com.buzzware.mood.databinding.AlertDialogSaveBookmarkBinding;
import com.buzzware.mood.databinding.BottomsheetDialogCommentsBinding;
import com.buzzware.mood.databinding.BottomsheetDialogLocationBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.io.IOException;
import java.util.List;

import eightbitlab.com.blurview.RenderScriptBlur;

public class FoodItemDetailForFavoriteActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    ActivityFoodItemDetailForFavoriteBinding binding;

    BottomsheetDialogLocationBinding binding2;
    Dialog bottomSheetDialog;
    private FusedLocationProviderClient fusedLocationClient;
    boolean checkLike=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodItemDetailForFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();

        setUpBottomSheetLocation();
        float radius = 20f;

        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();

        binding.blurView2.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(5f)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);

        binding.blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);


    }

    private void setListener() {
        binding.commentIV.setOnClickListener(view -> {
//            showBottomSheetDialog();
            showDialogComment();
        });

        binding.backIV.setOnClickListener(v -> {
            finish();
        });
        binding.likeIV.setOnClickListener(v -> {
            if (checkLike) {
                binding.hartIV.setImageResource(R.drawable.like);
                checkLike = false;
            } else {
                binding.hartIV.setImageResource(R.drawable.fill_like_icon);
                checkLike = true;
            }
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
            Intent intent = new Intent(FoodItemDetailForFavoriteActivity.this, SongInfoActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        binding.locationIV.setOnClickListener(view -> {
            showBottomSheetDialogLocation();
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
    private void showDialogComment() {
        Dialog dialog;
        dialog = new Dialog(this, android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final BottomsheetDialogCommentsBinding dialogBinding = BottomsheetDialogCommentsBinding.inflate(LayoutInflater.from(this));
        dialog.setContentView(dialogBinding.getRoot());
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        dialogBinding.recyclerViewComments.setLayoutManager(layoutManager5);
        dialogBinding.recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        dialogBinding.recyclerViewComments.setAdapter(new RecyclerViewAdapterComments(this, null));


        dialogBinding.closeTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();

    }


    private void showBottomSheetDialogLocation() {
        checkMapPermissions();
        bottomSheetDialog.show();
    }

    private void checkMapPermissions() {
        Permissions.check(this, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, new PermissionHandler() {
            @Override
            public void onGranted() {
            }
        });
    }

    public void setUpBottomSheetLocation() {


        bottomSheetDialog = new Dialog(this, android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        bottomSheetDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        bottomSheetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        bottomSheetDialog.setCancelable(true);
        binding2 = BottomsheetDialogLocationBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding2.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        binding2.locationIV.setOnClickListener(v -> {
            getLocation();
        });
        binding2.applyTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
        binding2.closeTV.setOnClickListener(v -> {
            bottomSheetDialog.dismiss();
        });
    }


    private void getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission not granted go to setting and allow location permission", Toast.LENGTH_SHORT).show();
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(sydney).title("Your Current Location"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));

                            ConvertLatLangToAddress(location.getLatitude(), location.getLongitude());

                        } else {
                            LatLng sydney = new LatLng(-34, 151);
                            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
                        }
                    }
                });
    }

    private String ConvertLatLangToAddress(double latitude, double longitude) {
        String city = "";
        String address = "UNKNOWN";
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                address = addresses.get(0).getAddressLine(0);
//                city = addresses.get(0).getLocality();
                binding2.locationTV.setText(address);
            }

        } catch (IOException e) {

        }
        return address;
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