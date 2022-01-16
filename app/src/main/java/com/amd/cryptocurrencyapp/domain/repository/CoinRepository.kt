package com.amd.cryptocurrencyapp.domain.repository

import com.amd.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.amd.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}