package com.example.moviesmvvmproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvvmproject.http.ApiCallback
import com.example.moviesmvvmproject.http.ApiClient
import com.example.moviesmvvmproject.http.ApiStores
import com.example.moviesmvvmproject.model.MoviesBean
import com.example.moviesmvvmproject.ui.BaseActivity
import com.example.moviesmvvmproject.ui.MovieAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : BaseActivity() {

//    @Inject
//    private lateinit var api: ApiStores

    var movieAdapter = MovieAdapter()
    var movieGlobal = MoviesBean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResponse()

//        jumpNew()

    }

    private fun jumpNew() {
        val btnSkip = findViewById<TextView>(R.id.tv_skip)
        btnSkip.setOnClickListener{
            startActivity(Intent(this, BlankActivity::class.java))
        }
    }

    private fun getResponse() {
        ApiClient.retrofit().loadData("c06e14cd13b2c6373fdc8f9f3dd47eb3")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = { Log.d("hui", "onFailure=" + it.message) },
                onNext = { movies ->
                    Log.d("hui", "title=" + movies.results.get(0).title)
                    movieGlobal = movies
                    setupRecyclerView()
                },
                onComplete = { Log.d("hui", "onFinish") }
            )
            .disposeOnDestroy()
    }


    private fun setupRecyclerView() {
        movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            movieAdapter.updateList(movieGlobal.results)
        }
    }


//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.tv_skip-> {
//                startActivity(Intent(this, BlankActivity::class.java))
//            }
//        }
//    }


}