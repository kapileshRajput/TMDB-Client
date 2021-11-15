package com.rajputkapilesh.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rajputkapilesh.tmdbclient.domain.usecases.GetMoviesUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}