package com.coyul.catsapp.domain

import com.coyul.catsapp.data.CatModel
import com.coyul.catsapp.Result

class CatsUseCase(private val repository: CatsRepository) {
    suspend fun getCats(): Result<List<CatModel>> = repository.getCats()
}