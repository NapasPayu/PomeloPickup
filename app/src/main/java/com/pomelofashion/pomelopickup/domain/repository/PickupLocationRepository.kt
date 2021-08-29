package com.pomelofashion.pomelopickup.domain.repository

import com.pomelofashion.pomelopickup.domain.model.PickupLocation

interface PickupLocationRepository {
    suspend fun getPickupLocations(): Result<List<PickupLocation>>
}