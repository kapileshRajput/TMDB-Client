package com.rajputkapilesh.tmdbclient.data.repositories.tvshow.datasource

import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}