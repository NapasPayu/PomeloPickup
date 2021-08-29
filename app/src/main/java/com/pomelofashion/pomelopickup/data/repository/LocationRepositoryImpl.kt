package com.pomelofashion.pomelopickup.data.repository

import android.annotation.SuppressLint
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.pomelofashion.pomelopickup.data.mapper.LocationMapper
import com.pomelofashion.pomelopickup.domain.model.LatLng
import com.pomelofashion.pomelopickup.domain.repository.LocationRepository
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationRepositoryImpl(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val locationMapper: LocationMapper,
) : LocationRepository {
    companion object {
        private const val UPDATE_INTERVAL = 10000L
        private const val FASTEST_INTERVAL = 2000L
    }

    private val locationRequest = LocationRequest.create().apply {
        interval = UPDATE_INTERVAL
        fastestInterval = FASTEST_INTERVAL
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): Result<LatLng> {
        return suspendCoroutine { continuation ->
            fusedLocationProviderClient.requestLocationUpdates(
                locationRequest,
                object : LocationCallback() {
                    override fun onLocationResult(locationResult: LocationResult) {
                        val result =
                            Result.success(locationMapper.mapFromEntity(locationResult.lastLocation))
                        fusedLocationProviderClient.removeLocationUpdates(this)
                        continuation.resume(result)
                    }

                    override fun onLocationAvailability(locationAvailability: LocationAvailability) {
                        if (!locationAvailability.isLocationAvailable) {
                            fusedLocationProviderClient.lastLocation
                        }
                    }
                },
                null
            )
        }
    }
}