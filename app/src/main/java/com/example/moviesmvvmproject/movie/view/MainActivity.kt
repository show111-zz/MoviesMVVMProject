package com.example.moviesmvvmproject.movie.view

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvvmproject.http.ApiClient
import com.example.moviesmvvmproject.movie.data.MoviesBean
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.base.IBaseView
import com.example.moviesmvvmproject.movie.data.Result
import com.example.moviesmvvmproject.movie.viewmodel.MovieVM
import com.example.moviesmvvmproject.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), IBaseView {

//    @Inject
//    private lateinit var api: ApiStores

    private lateinit var movieVM: MovieVM

    var movieAdapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieVM = MovieVM(this)
    }

    override fun loadDataToViewSuccess(list: List<Result>) {
        setupRecyclerView(list)
        Log.d("hui", "loadDataToViewSuccess -- 主页面显示成功" +list.size )
    }

    override fun loadDataToViewFail(msg: String?) {
        Log.d("hui", "loadDataToViewSuccess -- 主页面显示失败"  )
    }


    /**
     * implement of the item click listener of recycler view
     */
    private fun setupRecyclerView(list: List<Result>) {
        movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
            movieAdapter.updateList(list)

            movieAdapter.onItemClick = {
                result -> Log.d("hui", result.title)
            }
        }
    }


}