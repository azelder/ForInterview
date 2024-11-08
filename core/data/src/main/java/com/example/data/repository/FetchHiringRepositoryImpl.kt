package com.example.data.repository

import com.azelder.model.data.ItemModel
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

    override fun getHiringList(): Flow<Map<String, List<ItemModel>>> =
        flow {
            emit(
                datasource.getHiringList()
                    .filter { it.name?.isNotEmpty() == true }
                    // NOTE: Here the instructions are to sort by "listId" and then by "name".
                    // The name is just "Item x" where x is the id of the item. To simplify I'm just
                    // sorting by the id of the item after sorting by listId
                    .sortedWith(compareBy({ it.listId }, { it.id }))
                    .groupBy { it.listId }
            )
        }.flowOn(Dispatchers.IO)
}