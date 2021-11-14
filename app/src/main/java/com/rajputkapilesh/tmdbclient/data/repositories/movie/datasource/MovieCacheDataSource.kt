package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource

import com.rajputkapilesh.tmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}