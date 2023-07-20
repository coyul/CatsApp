package com.coyul.catsapp.data

import com.coyul.catsapp.BuildConfig
import com.coyul.catsapp.data.model.CatModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    companion object {
        private const val AUTHORIZATION_HEADER = "x-api-key: "
    }

    @Headers(AUTHORIZATION_HEADER + BuildConfig.TOKEN)
    @GET("breeds")
    suspend fun getCats(
        @Query("page") page: Long,
        @Query("limit") limit: Long
    ): Response<List<CatModel>>
}