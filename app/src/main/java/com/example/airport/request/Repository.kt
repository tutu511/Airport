package com.example.airport.request

import android.util.Log
import com.example.airport.data.FlightInfo
import com.example.airport.request.NetworkModule.apiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object Repository {

    /**
     * 获取机场飞行数据
     */
    fun getFlightInfo(flyType: String, airPortID: String): Single<List<FlightInfo>> {
        return apiService.getFlightInfo(flyType, airPortID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { e -> handleError(e) }
    }

    private fun handleError(e: Throwable) {
        Log.e("ApiError", "Error occurred: ${e.message}")
    }

}