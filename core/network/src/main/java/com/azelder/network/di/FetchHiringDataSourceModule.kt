package com.azelder.network.di

import com.azelder.network.FetchHiringDataSource
import com.azelder.network.retrofit.FetchHiringDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FetchHiringDataSourceModule {

    @Binds
    fun bindFetchHiringDataSource(
        fetchHiringDataSourceImpl: FetchHiringDataSourceImpl
    ): FetchHiringDataSource
}