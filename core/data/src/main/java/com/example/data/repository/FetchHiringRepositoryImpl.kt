package com.example.data.repository

import com.azelder.model.data.HiringModel
import com.azelder.network.FetchHiringDataSource
import com.example.data.FetchHiringRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchHiringRepositoryImpl @Inject constructor(
    private val datasource: FetchHiringDataSource
) : FetchHiringRepository {

    override fun getHiringList(): Flow<List<HiringModel>> =
        flow {
            emit(
                datasource.getHiringList()
            )
        }.flowOn(Dispatchers.IO)
}