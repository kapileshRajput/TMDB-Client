package com.rajputkapilesh.tmdbclient.domain.repositories

import com.rajputkapilesh.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}