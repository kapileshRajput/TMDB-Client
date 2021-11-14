package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource

import com.rajputkapilesh.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies: List<Artist>)
    suspend fun clearAll()
}