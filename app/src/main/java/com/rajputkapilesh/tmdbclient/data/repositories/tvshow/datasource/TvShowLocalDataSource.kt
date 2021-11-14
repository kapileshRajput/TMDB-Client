package com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource

import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}