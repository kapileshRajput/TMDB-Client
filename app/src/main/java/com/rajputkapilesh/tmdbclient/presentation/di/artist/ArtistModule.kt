package com.rajputkapilesh.tmdbclient.presentation.di.artist

import com.rajputkapilesh.tmdbclient.domain.usecases.GetArtistsUseCase
import com.rajputkapilesh.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.rajputkapilesh.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}