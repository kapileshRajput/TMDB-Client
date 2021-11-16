package com.rajputkapilesh.tmdbclient.data.repositories.artist

import android.util.Log
import com.rajputkapilesh.tmdbclient.data.model.artist.Artist
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.rajputkapilesh.tmdbclient.domain.repositories.ArtistRepository
import java.lang.Exception

private const val TAG = "ArtistRepositoryImpl"

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        return artistList
    }

    suspend fun getArtistsFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromApi: ${e.message.toString()}")
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDb()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}