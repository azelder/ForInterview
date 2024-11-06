package com.azelder.network.retrofit

import com.azelder.model.data.HiringModel
import com.azelder.network.FetchHiringDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

interface FetchHiringDataSourceApi {

    @GET("/hiring.json")
    suspend fun getHiringList() : List<HiringModel>

}

@Singleton
internal class FetchHiringDataSourceImpl @Inject constructor() : FetchHiringDataSource {

    private val networkClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FetchHiringDataSourceApi::class.java)

    override suspend fun getHiringList(): List<HiringModel> = networkClient.getHiringList()

    companion object {
        // would move this to a config file
        const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com"
    }
}