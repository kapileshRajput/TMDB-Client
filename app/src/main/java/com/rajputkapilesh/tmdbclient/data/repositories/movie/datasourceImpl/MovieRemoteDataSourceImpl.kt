package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.api.TMDBService
import com.rajputkapilesh.tmdbclient.data.model.movie.MovieList
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}