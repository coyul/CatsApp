package com.coyul.catsapp.domain

import com.coyul.catsapp.data.CatModel
import com.coyul.catsapp.Result

interface CatsRepository {
    suspend fun getCats(): Result<List<CatModel>>
}