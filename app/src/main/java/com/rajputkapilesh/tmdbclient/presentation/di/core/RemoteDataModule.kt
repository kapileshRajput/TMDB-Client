package com.rajputkapilesh.tmdbclient.presentation.di.core

import com.rajputkapilesh.tmdbclient.data.api.TMDBService
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

}