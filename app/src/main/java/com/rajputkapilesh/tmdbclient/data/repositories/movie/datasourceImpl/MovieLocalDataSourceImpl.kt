package com.rajputkapilesh.tmdbclient.data.repositories.movie.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.db.MovieDao
import com.rajputkapilesh.tmdbclient.data.model.movie.Movie
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()


    override suspend fun saveMoviesToDB(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}