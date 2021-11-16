package com.rajputkapilesh.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.rajputkapilesh.tmdbclient.data.db.ArtistDao
import com.rajputkapilesh.tmdbclient.data.db.MovieDao
import com.rajputkapilesh.tmdbclient.data.db.TMDBDataBase
import com.rajputkapilesh.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDataBase {
        return Room.databaseBuilder(context, TMDBDataBase::class.java, "tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDataBase: TMDBDataBase): MovieDao {
        return tmdbDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDataBase: TMDBDataBase): TvShowDao {
        return tmdbDataBase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDataBase: TMDBDataBase): ArtistDao {
        return tmdbDataBase.artistDao()
    }
}