package com.rajputkapilesh.tmdbclient.presentation.di.movie

import com.rajputkapilesh.tmdbclient.presentation.artist.ArtistActivity
import com.rajputkapilesh.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}