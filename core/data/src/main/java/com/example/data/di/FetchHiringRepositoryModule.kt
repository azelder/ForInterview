package com.example.data.di

import com.example.data.FetchHiringRepository
import com.example.data.repository.FetchHiringRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FetchHiringRepositoryModule {

    @Binds
    fun bindFetchHiringRepository(
        fetchHiringRepositoryImpl: FetchHiringRepositoryImpl
    ): FetchHiringRepository

}