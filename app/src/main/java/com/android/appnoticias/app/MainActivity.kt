package com.android.appnoticias.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.appnoticias.network.NetworkUtils
import com.android.appnoticias.R
import com.android.appnoticias.entities.Article
import com.android.appnoticias.entities.NewResult
import com.android.appnoticias.network.ArticlesService
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://newsapi.org/v2/")

        val endpoint = retrofitClient.create(ArticlesService::class.java)
        val callback = endpoint.getArticles("br")

        callback.enqueue(object : Callback<NewResult> {
            override fun onFailure(call: Call<NewResult>, t: Throwable) {
                Log.e("RESPOSTA", t.message, t)
            }

            override fun onResponse(call: Call<NewResult>, response: Response<NewResult>) {
                Log.d("RESPOSTA", response.body()?.totalResults.toString())
                loadRecyclerView(response.body()?.article)
            }
        })
    }

    private fun loadRecyclerView(articles : List<Article>?) {
        val adapter = GroupAdapter<ViewHolder>()
        articles?.forEach{
            adapter.add(ArticleItem(it))
        }

        recycler.adapter = adapter
    }

}
