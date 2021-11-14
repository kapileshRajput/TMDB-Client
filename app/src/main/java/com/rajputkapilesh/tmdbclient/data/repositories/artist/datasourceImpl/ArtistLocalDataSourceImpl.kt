package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.db.ArtistDao
import com.rajputkapilesh.tmdbclient.data.model.artist.Artist
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(movies: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}