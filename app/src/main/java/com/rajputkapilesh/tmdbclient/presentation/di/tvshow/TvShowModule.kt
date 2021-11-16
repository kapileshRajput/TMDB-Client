package com.rajputkapilesh.tmdbclient.presentation.di.tvshow

import com.rajputkapilesh.tmdbclient.domain.usecases.*
import com.rajputkapilesh.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.rajputkapilesh.tmdbclient.presentation.movie.MovieViewModelFactory
import com.rajputkapilesh.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
       getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}