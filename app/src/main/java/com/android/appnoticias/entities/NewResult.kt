package com.android.appnoticias.entities


import com.android.appnoticias.entities.Article
import com.google.gson.annotations.SerializedName

class NewResult (

    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var article: List<Article>

)
{

}