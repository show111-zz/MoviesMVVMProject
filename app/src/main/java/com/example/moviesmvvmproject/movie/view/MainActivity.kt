package com.example.moviesmvvmproject.movie.view

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.base.BaseActivity
import com.example.moviesmvvmproject.movie.model.MovieModelImpl
import com.example.moviesmvvmproject.movie.viewmodel.MovieVM
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private val movieVM = MovieVM(MovieModelImpl())

    @Inject
    lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = {
                result ->
                    val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                    intent.putExtra("url_image", result.poster_path)
                    intent.putExtra("title", result.title)
                    intent.putExtra("description", result.overview)
                    startActivity(intent)
        }
        movieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        movieVM.movies
            .subscribe { results ->
                movieAdapter.updateList(results)
                movieAdapter.notifyDataSetChanged()
            }
            .add()

    }


}
