package com.example.test.feature_detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.library.networks.api.Constants.IMAGE_PREFIX_URL
import com.example.library.networks.model.Detail
import com.example.test.feature_detail.R
import com.example.test.feature_detail.usecase.DetailUseCase
import com.example.test.feature_detail.viewmodel.DetailVM
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject

class MovieDetailFragment : DaggerFragment() {

    private val args by navArgs<MovieDetailFragmentArgs>()

    @Inject
    lateinit var detailUseCaseImpl: DetailUseCase

    private lateinit var detailVM: DetailVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movie_detail,container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailVM = DetailVM(
            detailUseCaseImpl,
            args.movieId
        ).also {
            it.detailState.observe(this) { detailState -> handleDetailStat(detailState) }
        }
    }

    private fun handleDetailStat(detailState: DetailVM.DetailState) {
        when (detailState) {
            is DetailVM.DetailState.DetailLoaded -> handleDataDetail(detailState.detailItem)
            is DetailVM.DetailState.DetailLoading -> handleLoading()
            is DetailVM.DetailState.DetailError -> handleError()
        }
    }

    private fun handleError() {
        movieTitle.text = "Something is wrong...."
    }

    private fun handleLoading() {
        movieTitle.text = "loading...."
    }

    private fun handleDataDetail(detailItem: Detail) {
        movieTitle.text = detailItem.title
        movieDescription.text = detailItem.overview
        dateRelease.text = detailItem.release_date
        Glide.with(this)
            .load(IMAGE_PREFIX_URL + detailItem.poster_path)
            .into(imgPoster)
    }

}


