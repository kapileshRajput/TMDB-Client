package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.model.movie.Movie
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}