package com.amd.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amd.cryptocurrencyapp.common.Constants
import com.amd.cryptocurrencyapp.common.Resource
import com.amd.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinState())
    val state: State<CoinState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(id: String) {
        getCoinUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}