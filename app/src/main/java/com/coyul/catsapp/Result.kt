package com.coyul.catsapp

sealed class Result<S> {
    data class Success<S>(val value: S) : Result<S>()
    data class Error<S, E>(val value: S? = null, val error: E?) : Result<S>()
}

val <S> Result<S>.value: S?
    get() = when (this) {
        is Result.Success -> value
        is Result.Error<S, *> -> value
    }