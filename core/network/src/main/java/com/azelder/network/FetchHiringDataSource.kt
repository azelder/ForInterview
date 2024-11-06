package com.azelder.network

import com.azelder.model.data.HiringModel

/**
 * Public facing interface
 */
interface FetchHiringDataSource {
    suspend fun getHiringList(): List<HiringModel>
}