package com.rajputkapilesh.tmdbclient.presentation.di.core

import com.rajputkapilesh.tmdbclient.data.repositories.artist.ArtistRepositoryImpl
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.MovieRepositoryImpl
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.TvShowRepositoryImpl
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDataSource
import com.rajputkapilesh.tmdbclient.domain.repositories.ArtistRepository
import com.rajputkapilesh.tmdbclient.domain.repositories.MovieRepository
import com.rajputkapilesh.tmdbclient.domain.repositories.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}