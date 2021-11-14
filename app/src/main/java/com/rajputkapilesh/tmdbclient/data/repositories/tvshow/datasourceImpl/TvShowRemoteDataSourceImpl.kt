package com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.api.TMDBService
import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShowList
import com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}