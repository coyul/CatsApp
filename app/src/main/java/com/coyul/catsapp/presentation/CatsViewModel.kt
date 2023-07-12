package com.coyul.catsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coyul.catsapp.Result
import com.coyul.catsapp.data.CatModel
import com.coyul.catsapp.domain.CatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val catsUseCase: CatsUseCase) : ViewModel() {

    private val listStateInternal = MutableLiveData<CatsListResult>()
    val listState: LiveData<CatsListResult> = listStateInternal

    init {
        viewModelScope.launch {
            listStateInternal.value = CatsListResult.Loading
            viewModelScope.launch {
                listStateInternal.value = catsUseCase.getCats().asCatsListResult()
            }
        }
    }
}

private fun Result<List<CatModel>>.asCatsListResult(): CatsListResult =
    when (this) {
        is Result.Success -> CatsListResult.CatsList(items = value.map { it.asCat() })
        else -> CatsListResult.Error
    }

private fun CatModel.asCat() = Cat(name = name, description = description, imageUrl = image?.url)
