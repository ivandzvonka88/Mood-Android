package com.buzzware.mood.classes;

public class ShowSubCategoriesEventBuss {
    String title="";

    public ShowSubCategoriesEventBuss(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
