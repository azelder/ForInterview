package com.example.data

import com.azelder.model.data.ItemModel
import kotlinx.coroutines.flow.Flow

interface FetchHiringRepository {

    /**
     * Returns the list of items
     */
    fun getHiringList(): Flow<Map<String, List<ItemModel>>>
}