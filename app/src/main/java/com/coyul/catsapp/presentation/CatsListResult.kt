package com.coyul.catsapp.presentation

sealed class CatsListResult() {
    data class CatsList(val items: List<Cat>) : CatsListResult()
    object Error : CatsListResult()
    object Loading : CatsListResult()
}