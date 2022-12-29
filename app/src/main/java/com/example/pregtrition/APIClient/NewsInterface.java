package com.example.pregtrition.APIClient;

import com.example.pregtrition.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsInterface {

    @GET("mahasiswa/")
    Call<List<News>> getNews();
}
