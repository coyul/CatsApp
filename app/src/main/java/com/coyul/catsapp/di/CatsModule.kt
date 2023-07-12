package com.coyul.catsapp.di

import com.coyul.catsapp.data.ApiService
import com.coyul.catsapp.data.CatsApi
import com.coyul.catsapp.data.CatsRepositoryImpl
import com.coyul.catsapp.domain.CatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class CatsModule {

    @Provides
    fun provideCatsUseCase(
        apiService: ApiService
    ): CatsUseCase = CatsUseCase(CatsRepositoryImpl(CatsApi(apiService)))
}