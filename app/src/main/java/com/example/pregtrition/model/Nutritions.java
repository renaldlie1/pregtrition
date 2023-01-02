package com.example.pregtrition.model;

import com.google.gson.annotations.SerializedName;

public class Nutritions {


    @SerializedName("food_name")
    private String food_name;
    @SerializedName("calories")
    private String calories;
    @SerializedName("time")
    private String time;

    public Nutritions(String food_name, String calories, String time) {
        this.food_name = food_name;
        this.calories = calories;
        this.time = time;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
