package com.coyul.catsapp.data

import com.coyul.catsapp.domain.CatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Repository calls API directly, but if we will add more complexity, for instance with cache,
// it will be wise to add DataSource layer in between
class CatsRepositoryImpl(private val api: CatsApi) : CatsRepository {
    override suspend fun getCats() = withContext(Dispatchers.IO) {
        return@withContext api.getCats()
    }
}