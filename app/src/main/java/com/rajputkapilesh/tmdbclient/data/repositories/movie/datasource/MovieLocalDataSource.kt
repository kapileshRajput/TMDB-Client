package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource

import com.rajputkapilesh.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}