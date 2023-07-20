package com.coyul.catsapp.domain

import com.coyul.catsapp.data.model.CatModel
import com.coyul.catsapp.Result

// Domain layer is just proxy as no specific business requirements in such simple app
class CatsUseCase(private val repository: CatsRepository) {
    suspend fun getCats(): Result<List<CatModel>> = repository.getCats()
}