package com.amd.cryptocurrencyapp.domain.model

data class Coin(
    val symbol: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val id: String,
    val type: String
)
