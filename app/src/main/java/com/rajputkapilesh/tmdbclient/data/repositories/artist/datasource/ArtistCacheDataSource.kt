package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource

import com.rajputkapilesh.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}