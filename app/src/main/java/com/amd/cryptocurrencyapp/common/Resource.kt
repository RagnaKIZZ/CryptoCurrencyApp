package com.amd.cryptocurrencyapp.common

sealed class Resource<out T> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}
