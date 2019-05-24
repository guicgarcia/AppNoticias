package com.android.appnoticias.network

import com.android.appnoticias.entities.NewResult
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ArticlesService {

    @GET("top-headLines")
    fun getArticles(
        @Query("q")
        busca: String,

        @Query("country")
        pais: String = "br",

        @Query("apiKey")
        apiKey: String = "13168274b19943689aa7de7c48f3638a"
    ): Call<NewResult>

}