package com.example.archek.aleftask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Service {

    @GET("task-m-001/list.php")
    Call<List<String>> getPictures();

}
