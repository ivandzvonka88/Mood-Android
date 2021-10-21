package com.buzzware.mood.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.buzzware.mood.R;
import com.buzzware.mood.activity.FoodItemDetailActivity;
import com.buzzware.mood.activity.ManageAccountActivity;
import com.buzzware.mood.activity.SelectCategoriesActivity;
import com.buzzware.mood.activity.SongInfoActivity;
import com.buzzware.mood.adapter.AddBookmarkItemAdapter;
import com.buzzware.mood.adapter.CategoriesItemAdapter;
import com.buzzware.mood.adapter.FoodItemDetailAdapter;
import com.buzzware.mood.adapter.ImageSliderViewPagerAdapter;
import com.buzzware.mood.adapter.MyAdapter;
import com.buzzware.mood.adapter.RecyclerViewAdapterComments;
import com.buzzware.mood.adapter.RecyclerViewAdapterMessages;
import com.buzzware.mood.adapter.SubCategoriesBookmarkItemAdapter;
import com.buzzware.mood.classes.ShowSubCategoriesEventBuss;
import com.buzzware.mood.databinding.AlertDialogBookmarkSavedBinding;
import com.buzzware.mood.databinding.AlertDialogDeleteAccountBinding;
import com.buzzware.mood.databinding.AlertDialogSaveBookmarkBinding;
import com.buzzware.mood.databinding.BottomsheetDialogBookmarksBinding;
import com.buzzware.mood.databinding.BottomsheetDialogCommentsBinding;
import com.buzzware.mood.databinding.BottomsheetDialogLocationBinding;
import com.buzzware.mood.databinding.BottomsheetDialogMessagesBinding;
import com.buzzware.mood.databinding.FragmentActivityBinding;
import com.buzzware.mood.databinding.FragmentFoodItemDetailBinding;
import com.buzzware.mood.model.BookmarkModel;
import com.buzzware.mood.model.CategoriesModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.RenderScriptBlur;


public class FoodItemDetailFragment extends Fragment implements OnMapReadyCallback {

    FragmentFoodItemDetailBinding binding;
    private GoogleMap mMap;
    private List<String> stringList = new ArrayList<>();
    boolean checkLike = false;

    BottomsheetDialogLocationBinding binding2;
    Dialog bottomSheetDialog;
    private FusedLocationProviderClient fusedLocationClient;
    ArrayList<BookmarkModel> data = new ArrayList<>();
    ArrayList<String> subCateData = new ArrayList<>();

    Dialog bookmarkDialog;
    BottomsheetDialogBookmarksBinding bookMarkdialogBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodItemDetailBinding.inflate(inflater, container, false);

        setListener();
        // SetSlider();
        initRecyclerViewFoodItems();
        float radius = 20f;

        View decorView = getActivity().getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        binding.blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(getContext()))
                .setBlurRadius(radius)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);

        setUpBottomSheetLocation();


        return binding.getRoot();
    }

    public void setUpBottomSheetLocation() {


        bottomSheetDialog = new Dialog(getContext(), android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        bottomSheetDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        bottomSheetDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        bottomSheetDialog.setCancelable(true);
        binding2 = BottomsheetDialogLocationBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding2.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
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

    private void checkMapPermissions() {
        Permissions.check(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, new PermissionHandler() {
            @Override
            public void onGranted() {
            }
        });
    }

    private void getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getContext(), "Permission not granted go to setting and allow location permission", Toast.LENGTH_SHORT).show();
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
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
        Geocoder geocoder = new Geocoder(getContext());
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

    private void initRecyclerViewFoodItems() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.foodItemsRV.setLayoutManager(linearLayoutManager);

        FoodItemDetailAdapter adapter = new FoodItemDetailAdapter(getContext(), null);
        binding.foodItemsRV.setItemAnimator(new DefaultItemAnimator());
        binding.foodItemsRV.setAdapter(adapter);
    }

    private void setListener() {
        binding.backIV.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });
        binding.bookmarkIV.setOnClickListener(v -> {
            showDialogBookMark();
        });
        binding.commentIV.setOnClickListener(view -> {
//            showBottomSheetDialog();
            showDialogComment();
        });
        binding.messageIV.setOnClickListener(v -> {
            showDialogMessages();
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
            Intent intent = new Intent(getActivity(), SongInfoActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        binding.locationIV.setOnClickListener(view -> {
            showBottomSheetDialogLocation();
        });

    }

//    private void showBottomSheetDialogSaveBookmarks() {
//        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.SheetDialog);
//        final AlertDialogSaveBookmarkBinding binding1 = AlertDialogSaveBookmarkBinding.inflate(getLayoutInflater());
//        bottomSheetDialog.setContentView(binding1.getRoot());
//        binding1.applyTV.setOnClickListener(view -> {
//            bottomSheetDialog.dismiss();
//        });
//        binding1.closeTV.setOnClickListener(view -> {
//            bottomSheetDialog.dismiss();
//        });
//        binding1.createNewCL.setOnClickListener(v -> {
//            binding1.createNewIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
//            binding1.burgersIV.setImageDrawable(null);
//            binding1.mexicanEatsIV.setImageDrawable(null);
//            binding1.lASportsIV.setImageDrawable(null);
//        });
//        binding1.burgersCL.setOnClickListener(v -> {
//            binding1.createNewIV.setImageDrawable(null);
//            binding1.burgersIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
//            binding1.mexicanEatsIV.setImageDrawable(null);
//            binding1.lASportsIV.setImageDrawable(null);
//        });
//        binding1.mexicanEatsCL.setOnClickListener(v -> {
//            binding1.createNewIV.setImageDrawable(null);
//            binding1.burgersIV.setImageDrawable(null);
//            binding1.mexicanEatsIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
//            binding1.lASportsIV.setImageDrawable(null);
//        });
//        binding1.lASportsCL.setOnClickListener(v -> {
//            binding1.createNewIV.setImageDrawable(null);
//            binding1.burgersIV.setImageDrawable(null);
//            binding1.mexicanEatsIV.setImageDrawable(null);
//            binding1.lASportsIV.setImageDrawable(getResources().getDrawable(R.drawable.tick));
//        });
//        bottomSheetDialog.show();
//    }

    private void showBottomSheetDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.SheetDialog);
        final BottomsheetDialogCommentsBinding binding1 = BottomsheetDialogCommentsBinding.inflate(getLayoutInflater());
        bottomSheetDialog.setContentView(binding1.getRoot());

        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding1.recyclerViewComments.setLayoutManager(layoutManager5);
        binding1.recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        binding1.recyclerViewComments.setAdapter(new RecyclerViewAdapterComments(getActivity(), null));


        binding1.closeTV.setOnClickListener(view -> {
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.show();

    }

    private void showDialogComment() {
        Dialog dialog;
        dialog = new Dialog(getContext(), android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final BottomsheetDialogCommentsBinding dialogBinding = BottomsheetDialogCommentsBinding.inflate(LayoutInflater.from(getContext()));
        dialog.setContentView(dialogBinding.getRoot());
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        dialogBinding.recyclerViewComments.setLayoutManager(layoutManager5);
        dialogBinding.recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        dialogBinding.recyclerViewComments.setAdapter(new RecyclerViewAdapterComments(getActivity(), null));


        dialogBinding.closeTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();

    }

    private void showDialogBookMark() {

        bookmarkDialog = new Dialog(getContext(), android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        bookmarkDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        bookmarkDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        bookmarkDialog.setCancelable(true);
        bookMarkdialogBinding = BottomsheetDialogBookmarksBinding.inflate(LayoutInflater.from(getContext()));
        bookmarkDialog.setContentView(bookMarkdialogBinding.getRoot());

        data.clear();
        data.add(new BookmarkModel("Healthy Food (6)","Sweets (0)", ""));
        data.add(new BookmarkModel("Vegan (0)", "Bakery (0)", "Meat (0)"));
        data.add(new BookmarkModel("Mediterranean cuisine (0) ", "", ""));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        bookMarkdialogBinding.mainRV.setLayoutManager(linearLayoutManager);
        bookMarkdialogBinding.mainRV.setAdapter(new AddBookmarkItemAdapter(getContext(), data));


        subCateData.clear();
        subCateData.add("Fruits");
        subCateData.add("Vegetables");
        subCateData.add("Grain");
        subCateData.add("Milk");
        subCateData.add("Meats");
        subCateData.add("Fish and seafood");
        LinearLayoutManager linearLayoutManagerSubCategories = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false);
        bookMarkdialogBinding.subCategoriesRV.setLayoutManager(linearLayoutManagerSubCategories);
        bookMarkdialogBinding.subCategoriesRV.setAdapter(new SubCategoriesBookmarkItemAdapter(getContext(), subCateData));


        bookMarkdialogBinding.addSubCategoriesBTN.setOnClickListener(v -> {
            bookMarkdialogBinding.subCategoriesET.setVisibility(View.VISIBLE);
        });
        bookMarkdialogBinding.closeTV.setOnClickListener(view -> {
            bookmarkDialog.dismiss();
        });
        bookMarkdialogBinding.applyTV.setOnClickListener(view -> {
            bookmarkDialog.dismiss();
        });
        bookMarkdialogBinding.creatBookmarkBT.setOnClickListener(view -> {
            showDialogSaved();
            bookmarkDialog.dismiss();
        });

        bookmarkDialog.show();

    }
    private void showDialogSaved() {
        Dialog dialog;
        dialog = new Dialog(getContext(), R.style.Theme_AppCompat_Dialog_Alert);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final AlertDialogBookmarkSavedBinding dialogBinding = AlertDialogBookmarkSavedBinding.inflate(LayoutInflater.from(getContext()));
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.okBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ShowSubCategoriesEventBuss event) {
        if(event.getTitle().equals("Healthy Food (6)")){
            bookMarkdialogBinding.bookMarkDetailLL.setVisibility(View.VISIBLE);
            data.clear();
            data.add(new BookmarkModel("Sweets (0)","Vegan (0)", "Bakery (0)"));
            data.add(new BookmarkModel("Meat (0)","Mediterranean cuisine (0) ", ""));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            bookMarkdialogBinding.mainRV.setLayoutManager(linearLayoutManager);
            bookMarkdialogBinding.mainRV.setAdapter(new AddBookmarkItemAdapter(getContext(), data));
        }else{
            bookMarkdialogBinding.bookMarkDetailLL.setVisibility(View.GONE);
            data.clear();
            data.add(new BookmarkModel("Healthy Food (6)","Sweets (0)", ""));
            data.add(new BookmarkModel("Vegan (0)", "Bakery (0)", "Meat (0)"));
            data.add(new BookmarkModel("Mediterranean cuisine (0) ", "", ""));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            bookMarkdialogBinding.mainRV.setLayoutManager(linearLayoutManager);
            bookMarkdialogBinding.mainRV.setAdapter(new AddBookmarkItemAdapter(getContext(), data));
        }

        bookMarkdialogBinding.categoriesNameTV.setText(event.getTitle());
    }

    private void showDialogMessages() {
        Dialog dialog;
        dialog = new Dialog(getContext(), android.R.style.Theme_Holo_NoActionBar_Fullscreen);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        final BottomsheetDialogMessagesBinding dialogBinding = BottomsheetDialogMessagesBinding.inflate(LayoutInflater.from(getContext()));
        dialog.setContentView(dialogBinding.getRoot());
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        dialogBinding.messagesRV.setLayoutManager(layoutManager5);
        dialogBinding.messagesRV.setItemAnimator(new DefaultItemAnimator());
        dialogBinding.messagesRV.setAdapter(new RecyclerViewAdapterMessages(getActivity(), null));


        dialogBinding.closeTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialogBinding.doneTV.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialogBinding.sendBT.setOnClickListener(view -> {
            dialog.dismiss();
        });
        dialog.show();

    }


    private void showBottomSheetDialogLocation() {
        checkMapPermissions();
        bottomSheetDialog.show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
    }

    public void SetSlider() {
        addData();
        binding.viewPager.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager(), getContext(), stringList));


    }

    private void addData() {
        for (int i = 0; i < 8; i++) {
            stringList.add(String.valueOf(i));
        }
    }
}