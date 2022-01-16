package com.amd.cryptocurrencyapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.amd.cryptocurrencyapp.domain.model.Coin

data class CoinDto(

	@field:SerializedName("symbol")
	val symbol: String,

	@field:SerializedName("is_active")
	val isActive: Boolean,

	@field:SerializedName("is_new")
	val isNew: Boolean,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("rank")
	val rank: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("type")
	val type: String
)

fun CoinDto.toCoin() = Coin(
	id = id,
	isActive = isActive,
	name = name,
	rank = rank,
	symbol = symbol,
	type = type
)
