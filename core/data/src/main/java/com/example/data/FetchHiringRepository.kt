package com.example.data

import com.azelder.model.data.HiringModel
import kotlinx.coroutines.flow.Flow

interface FetchHiringRepository {

    /**
     * Returns the list of hiring candidates
     */
    fun getHiringList(): Flow<List<HiringModel>>
}