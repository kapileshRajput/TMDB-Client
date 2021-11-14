package com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShow
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}