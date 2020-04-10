package com.example.moviesmvvmproject.movie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesmvvmproject.base.TestSchedulerProvider
import com.example.test.network.map.DetailMapper
import com.example.test.network.map.MoviesMapper
import com.example.feature.featurehome.usecase.MovieUseCaseImpl
import com.example.feature.featurehome.viewmodel.MovieVM
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit


/**
 * Created by hannah on 2020-02-05
 * using Mockito
 */
@RunWith(JUnit4::class)
class MovieVMTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieUseCase: MovieUseCaseImpl

    @Mock
    lateinit var movies: Single<List<com.example.library.networks.model.Movie>>

    lateinit var movieViewModel: MovieVM

    lateinit var movieState: MovieVM.MovieState

    var moviesMapper: MoviesMapper =
        MoviesMapper()
    var detailMapper: DetailMapper =
        DetailMapper()
    val baseAPIRepository: com.example.test.network.BaseAPIRepositoryImpl =
        com.example.test.network.BaseAPIRepositoryImpl(moviesMapper, detailMapper)

    val testScheduler = TestScheduler()
    var testSchedulerProvider: TestSchedulerProvider = TestSchedulerProvider(testScheduler)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.movieViewModel = MovieVM(
            MovieUseCaseImpl(baseAPIRepository),
            testSchedulerProvider
        )
    }

    @Test
    fun getMoviesDataSuccess_SuccessResponse() {

        assertNotNull(this.movieViewModel)

        val movie1 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "mock title 1", false, 0.0, 0
        )
        val movie2 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "mock title 2", false, 0.0, 0
        )

        given(this.movieUseCase.getMovies()).willReturn(Single.just(listOf(movie1, movie2)))

        movieViewModel.getMovies()

        this.movieViewModel.movieState.value = MovieVM.MovieState.MovieLoaded(listOf(movie1, movie2))

        val testObserver = movieUseCase.getMovies()
            .subscribeOn(testSchedulerProvider.io())
            .observeOn(testSchedulerProvider.ui())
            .test()

        testObserver.assertNotTerminated().assertNoErrors().awaitCount(2)
    }

    @Test
    fun getMoviesData_DelayTest(){

        val movie1 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "delay test title 1", false, 0.0, 0
        )
        val movie2 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "delay test title 2", false, 0.0, 0
        )
        val movie3 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "delay test title 3", false, 0.0, 0
        )
        val movie4 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "delay test title 4", false, 0.0, 0
        )
        val movie5 = com.example.library.networks.model.Movie(
            false, "", null, -1, "", "", "",
            0.0, "", "", "delay test title 5", false, 0.0, 0
        )

        given(this.movieUseCase.getMovies()).willReturn(Single.just(listOf(movie1, movie2, movie3, movie4, movie5)))

        //given
        val observable = Observable.just(5).delay(1, TimeUnit.SECONDS, testScheduler)
        val testObserver = TestObserver<Int>()

        //when
        observable.subscribe(testObserver)
        //then
        testScheduler.advanceTimeBy(950, TimeUnit.MILLISECONDS)
        testObserver.assertNotTerminated()
        testScheduler.advanceTimeBy(60, TimeUnit.MILLISECONDS)
        testObserver.assertValue(5)
        testObserver.assertComplete()

    }

    @Test
    fun getMoviesDataSuccess_ErrorResponse() {

        `when`(this.movieUseCase.getMovies()).thenReturn(movies)

        this.movieState = MovieVM.MovieState.Error

        movieViewModel.movies

        assertNotNull(movieViewModel.movies)
    }

}
