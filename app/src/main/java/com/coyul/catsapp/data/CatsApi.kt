package com.coyul.catsapp.data

import com.coyul.catsapp.Result
import retrofit2.Response

class CatsApi(private val service: ApiService) {

    suspend fun getCats(
        page: Long = 1,
        limit: Long = 20
    ): Result<List<CatModel>> =
        safeApiCall { service.getCats(page, limit) }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> =
        try {
            apiCall.invoke().body()?.let { Result.Success(it) }
                ?: Result.Error(error = Error("Response body is null. For cats list it is considered as error."))
        } catch (t: Throwable) {
            Result.Error(error = t)
        }
}