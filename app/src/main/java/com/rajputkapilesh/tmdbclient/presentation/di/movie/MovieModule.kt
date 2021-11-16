package com.rajputkapilesh.tmdbclient.presentation.di.movie

import com.rajputkapilesh.tmdbclient.domain.usecases.GetArtistsUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.GetMoviesUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.rajputkapilesh.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.rajputkapilesh.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}