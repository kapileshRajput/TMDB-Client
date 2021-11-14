package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource

import com.rajputkapilesh.tmdbclient.data.model.movie.Movie
import com.rajputkapilesh.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}