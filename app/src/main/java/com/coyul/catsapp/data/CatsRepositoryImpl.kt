package com.coyul.catsapp.data

import com.coyul.catsapp.domain.CatsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsRepositoryImpl(private val api: CatsApi):CatsRepository {

    override suspend fun getCats() = withContext(Dispatchers.IO) {
        return@withContext api.getCats()
    }
}