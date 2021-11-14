package com.rajputkapilesh.tmdbclient.data.repositories.tvshow

import android.util.Log
import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShow
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDataSource
import com.rajputkapilesh.tmdbclient.domain.repositories.TvShowRepository
import java.lang.Exception

private const val TAG = "TvShowRepositoryImpl"

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }


    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowsList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowsList: List<TvShow>

        try {
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList = getTvShowsFromDb()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }
}