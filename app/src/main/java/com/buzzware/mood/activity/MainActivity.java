package com.buzzware.mood.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.buzzware.mood.R;
import com.buzzware.mood.classes.ShiftToFoodItemDetailFrag;
import com.buzzware.mood.databinding.ActivityMainBinding;
import com.buzzware.mood.fragment.ActivityFragment;
import com.buzzware.mood.fragment.FoodItemDetailFragment;
import com.buzzware.mood.fragment.HomeFragment;
import com.buzzware.mood.fragment.PopularFragment;
import com.buzzware.mood.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        setListener();
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());


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
        binding.postBtn.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,AddVideoActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.mainFragmentContainer.getId(), fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.home_nav:

                loadFragment(new HomeFragment());
                return true;

            case R.id.popular_nav:


                loadFragment(new PopularFragment());
                return true;

            case R.id.activity_nav:

                loadFragment(new ActivityFragment());
                return true;

            case R.id.profile_nav:

                loadFragment(new ProfileFragment());
                return true;


        }
        return false;
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
    public void onMessageEvent(ShiftToFoodItemDetailFrag event) {
        loadFragment(new FoodItemDetailFragment());/* Do something */
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if ( getSupportFragmentManager().getBackStackEntryCount()<=0) {
            finish();
        }
    }
}