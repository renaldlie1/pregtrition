package com.example.pregtrition.APIClient;


import com.example.pregtrition.model.Doctors;
import com.example.pregtrition.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("mahasiswa/")
    Call<List<News>> getNews();

    @GET("doctors" +
            "/")
    Call<List<Doctors>> getDoctors();



}
