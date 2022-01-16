package com.amd.cryptocurrencyapp.domain.use_case.get_coin

import com.amd.cryptocurrencyapp.common.Resource
import com.amd.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.amd.cryptocurrencyapp.domain.model.CoinDetail
import com.amd.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(id: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading)
            val coin = repository.getCoinById(id).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

}