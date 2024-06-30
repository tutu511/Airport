package com.example.airport.request

import com.example.airport.request.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val BASE_URL = "https://e-traffic.taichung.gov.tw/DataAPI/"
    private const val EXCHANGE_RATE_API_BASE_URL = "https://api.freecurrencyapi.com/v1/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        createRetrofit(BASE_URL).create(ApiService::class.java)
    }

//    val exchangeRateApiService: ExchangeRateApiService by lazy {
//        createRetrofit(EXCHANGE_RATE_API_BASE_URL).create(ExchangeRateApiService::class.java)
//    }
}