package com.rajputkapilesh.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rajputkapilesh.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}