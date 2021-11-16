package com.rajputkapilesh.tmdbclient.presentation.di

import com.rajputkapilesh.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.rajputkapilesh.tmdbclient.presentation.di.movie.MovieSubComponent
import com.rajputkapilesh.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}