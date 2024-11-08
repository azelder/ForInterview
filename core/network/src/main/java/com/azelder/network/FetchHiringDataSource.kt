package com.azelder.network

import com.azelder.model.data.ItemModel

/**
 * Public facing interface
 */
interface FetchHiringDataSource {
    suspend fun getHiringList(): List<ItemModel>
}