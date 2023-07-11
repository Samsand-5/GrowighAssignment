package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Adapter.NewsAdapter
import com.example.project.DataClass.News
import com.example.project.Interface.ApiInterface
import com.example.project.Interface.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
   lateinit var list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)
        list = findViewById(R.id.list)
        getNews()
    }

    private fun getNews() {
        val news : Call<News> = ApiInterface.apiInstance.getHeadLines("in",1)
        news.enqueue(object: Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news :News? = response.body()
                if(news!=null){
                    Log.d("Project", news.toString())
                    adapter = NewsAdapter(this@FeedsActivity,news.articles)
                    list.adapter = adapter
                    list.layoutManager = LinearLayoutManager(this@FeedsActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Project", "Error in fetching")
            }
        })
    }
}