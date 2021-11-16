package com.rajputkapilesh.tmdbclient.presentation.di.core

import com.rajputkapilesh.tmdbclient.data.db.ArtistDao
import com.rajputkapilesh.tmdbclient.data.db.MovieDao
import com.rajputkapilesh.tmdbclient.data.db.TvShowDao
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}