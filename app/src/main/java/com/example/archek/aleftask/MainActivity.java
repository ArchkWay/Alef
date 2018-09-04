package com.example.archek.aleftask;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        RecyclerView rv = findViewById( R.id.recycler );
        final ImageAdapter adapter = new ImageAdapter();
        int spanCount = getResources().getInteger( R.integer.span_count );//задаём количество рядов картинок
        GridLayoutManager lm = new GridLayoutManager( this, spanCount );//GridLayoutManager для сетчатых квадратных картинок
        rv.setLayoutManager( lm );
        rv.setAdapter( adapter );/*адаптер recycleview*/

        RestApi.createService( Service.class ).getPictures().enqueue( new Callback <List <String>>() {//с помощью Rest api загружаем картинки в список
            @Override
            public void onResponse(Call<List <String>> call, @Nullable Response<List <String>> response) {
                adapter.addAll( response.body() );//в adapter RecycleView
            }

            @Override
            public void onFailure(Call <List <String>> call, Throwable t) {

            }
        } );
    }


}
