package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.model.artist.Artist
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}