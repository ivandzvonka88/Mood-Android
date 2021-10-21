package com.buzzware.mood.model;

import android.graphics.drawable.Drawable;

public class CategoriesModel {

    Drawable image1;
    String name1;
    Drawable image2;
    String name2;

    public CategoriesModel(Drawable image1, String name1, Drawable image2, String name2) {
        this.image1 = image1;
        this.name1 = name1;
        this.image2 = image2;
        this.name2 = name2;
    }

    public Drawable getImage1() {
        return image1;
    }

    public void setImage1(Drawable image1) {
        this.image1 = image1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Drawable getImage2() {
        return image2;
    }

    public void setImage2(Drawable image2) {
        this.image2 = image2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
