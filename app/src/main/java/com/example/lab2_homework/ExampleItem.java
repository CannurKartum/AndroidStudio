package com.example.lab2_homework;

public class ExampleItem {
    private int mImageResource;
    private String name;
    private String gender;
    private String rating;
    private String number;
    private String color;


    public ExampleItem(int mImageResource, String name, String gender, String rating, String number, String color) {
        this.mImageResource = mImageResource;
        this.name = name;
        this.gender = gender;
        this.rating = rating;
        this.number = number;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
