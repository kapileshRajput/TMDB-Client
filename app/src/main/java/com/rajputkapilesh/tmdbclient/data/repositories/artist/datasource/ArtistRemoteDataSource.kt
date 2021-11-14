package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource

import com.rajputkapilesh.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}