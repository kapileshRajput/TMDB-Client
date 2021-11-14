package com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource

import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}