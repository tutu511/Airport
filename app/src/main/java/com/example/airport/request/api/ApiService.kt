package com.example.airport.request.api

import com.example.airport.data.FlightInfo
import com.example.airport.request.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(ApiAddress.FLIGHT_INFO + "{flyType}/{airPortID}")
    fun getFlightInfo(
        @Path("flyType") flyType: String,
        @Path("airPortID") airPortID: String
    ): Single<List<FlightInfo>>

}