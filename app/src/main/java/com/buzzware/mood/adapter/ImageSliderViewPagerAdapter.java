package com.buzzware.mood.adapter;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.buzzware.mood.R;

import java.util.ArrayList;


public class ImageSliderViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    ArrayList<String> list;
    //private Integer[] images = {R.drawable.hazzzir_one,R.drawable.hazzzir_two,R.drawable.hazzzir_three};

    public ImageSliderViewPagerAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list= list;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_design_food_item_detail, null);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
