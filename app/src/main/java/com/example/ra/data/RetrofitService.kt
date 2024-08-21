package com.example.ra.data;

import com.example.ra.model.TMDBResult

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header
import retrofit2.http.Query;

interface RetrofitService {

    @GET("movie/upcoming")
    suspend fun listPopularMovies(
            @Query("language") language: String,
        @Header("Authorization") apiKey: String,
        @Header("accept") accept: String,
    ): TMDBResult
}



object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
    }
}