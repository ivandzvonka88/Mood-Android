package com.buzzware.mood.activity;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.buzzware.mood.R;
import com.buzzware.mood.adapter.FoodItemDetailAdapter;
import com.buzzware.mood.adapter.RecyclerViewAdapterMaps;
import com.buzzware.mood.adapter.RecyclerViewAdapterMapsGrid;
import com.buzzware.mood.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationClient;
    boolean gridLoaded=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setView();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        setListener();

        checkMapPermissions();
        setRecyclerView();

        try {
            getLocation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        binding.includeView.backIV.setOnClickListener(v->{
            finish();
        });
    }

    private void setView() {
        binding.includeView.titleTV.setText("Healthy Food");
        binding.includeView.backIV.setVisibility(View.VISIBLE);
        binding.includeView.backIV.setImageDrawable(getResources().getDrawable(R.drawable.back_icon));
        binding.includeView.menuIV.setVisibility(View.GONE);
    }
    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MapsActivity.this, RecyclerView.HORIZONTAL,false);
        binding.mainRV.setLayoutManager(linearLayoutManager);

        RecyclerViewAdapterMaps adapter = new RecyclerViewAdapterMaps(MapsActivity.this, null);
        binding.mainRV.setItemAnimator(new DefaultItemAnimator());
        binding.mainRV.setAdapter(adapter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    private void checkMapPermissions() {
        Permissions.check(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, new PermissionHandler() {
            @Override
            public void onGranted() {
                try {
                    getLocation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void getLocation() throws Exception{
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(MapsActivity.this);
        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MapsActivity.this, "Permission not granted go to setting and allow location permission", Toast.LENGTH_SHORT).show();
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(MapsActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                            mMap.addMarker(new MarkerOptions().position(sydney).title("Your Location").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));

                        } else {
                            LatLng sydney = new LatLng(-34, 151);
                            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon)));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
                        }
                    }
                });
    }


}