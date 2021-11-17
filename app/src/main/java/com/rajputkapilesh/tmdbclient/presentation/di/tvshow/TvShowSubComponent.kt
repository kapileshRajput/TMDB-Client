package com.rajputkapilesh.tmdbclient.presentation.di.tvshow

import com.rajputkapilesh.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}