package com.rajputkapilesh.tmdbclient.data.repositories.movie

import android.util.Log
import com.rajputkapilesh.tmdbclient.data.model.movie.Movie
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.rajputkapilesh.tmdbclient.domain.repositories.MovieRepository
import java.lang.Exception

private const val TAG = "MovieRepositoryImpl"

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            Log.e(TAG, "getMoviesFromApi: ${body.toString()}", )
            if (body != null) {
                movieList = body.movies
            }else{
                Log.e(TAG, "getMoviesFromApi: Empty response body", )
            }
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        return movieList
    }


    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
           movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDb()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}