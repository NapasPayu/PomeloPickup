package com.pomelofashion.pomelopickup.domain.repository

import com.pomelofashion.pomelopickup.domain.model.LatLng

interface LocationRepository {
    suspend fun getCurrentLocation(): Result<LatLng>
}