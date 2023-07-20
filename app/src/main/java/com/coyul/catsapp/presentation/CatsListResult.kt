package com.coyul.catsapp.presentation

import com.coyul.catsapp.presentation.model.Cat

sealed class CatsListResult {
    data class CatsList(val items: List<Cat>) : CatsListResult()
    object Error : CatsListResult()
    object Loading : CatsListResult()
}