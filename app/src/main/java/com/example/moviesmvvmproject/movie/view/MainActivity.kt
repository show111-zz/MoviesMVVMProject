package com.example.moviesmvvmproject.movie.view

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvvmproject.http.ApiClient
import com.example.moviesmvvmproject.movie.model.MoviesBean
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.ui.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//    @Inject
//    private lateinit var api: ApiStores

    var movieAdapter = MovieAdapter()
    var movieGlobal = MoviesBean()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResponse()
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


    /**
     * implement of the item click listener of recycler view
     */
    private fun setupRecyclerView() {
        movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            movieAdapter.updateList(movieGlobal.results)

            movieAdapter.onItemClick = {
                result -> Log.d("hui", result.title)
            }
        }
    }


}