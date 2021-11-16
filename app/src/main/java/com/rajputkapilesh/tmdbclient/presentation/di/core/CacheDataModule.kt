package com.rajputkapilesh.tmdbclient.presentation.di.core

import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}