package com.example.archek.aleftask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Service {//задаём Get запрос для Rest

    @GET("task-m-001/list.php")
    Call<List<String>> getPictures();

}
