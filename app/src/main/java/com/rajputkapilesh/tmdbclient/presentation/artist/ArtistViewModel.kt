package com.rajputkapilesh.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rajputkapilesh.tmdbclient.domain.usecases.GetArtistsUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}