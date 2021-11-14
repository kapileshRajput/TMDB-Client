package com.rajputkapilesh.tmdbclient.data.repositories.artist.datasourceImpl

import com.rajputkapilesh.tmdbclient.data.api.TMDBService
import com.rajputkapilesh.tmdbclient.data.model.artist.ArtistList
import com.rajputkapilesh.tmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}