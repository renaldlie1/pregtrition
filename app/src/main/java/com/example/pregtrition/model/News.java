package com.example.pregtrition.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("news")
    private String news;

    public News(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
