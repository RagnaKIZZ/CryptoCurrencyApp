package com.amd.cryptocurrencyapp.presentation.coin_detail

import com.amd.cryptocurrencyapp.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)