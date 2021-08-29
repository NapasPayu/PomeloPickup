package com.pomelofashion.pomelopickup.data.remote

import com.pomelofashion.pomelopickup.data.model.PickupLocationResponseEntity
import retrofit2.http.GET
import retrofit2.http.Header

interface PickupLocationService {
    @GET("pickup-locations")
    suspend fun getPickupLocations(@Header("x-api-key") apiKey: String): PickupLocationResponseEntity
}