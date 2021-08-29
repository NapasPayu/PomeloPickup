package com.pomelofashion.pomelopickup.data.repository

import com.pomelofashion.pomelopickup.BuildConfig
import com.pomelofashion.pomelopickup.data.mapper.PickupLocationMapper
import com.pomelofashion.pomelopickup.data.model.PickupLocationEntity
import com.pomelofashion.pomelopickup.data.remote.PickupLocationService
import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.domain.repository.PickupLocationRepository

class PickupLocationRepositoryImpl(
    private val pickupLocationService: PickupLocationService,
    private val pickupLocationMapper: PickupLocationMapper,
) : PickupLocationRepository {

    override suspend fun getPickupLocations(): Result<List<PickupLocation>> {
        return runCatching {
            pickupLocationService.getPickupLocations(BuildConfig.API_KEY).pickup
                .filter(PickupLocationEntity::active)
                .map(pickupLocationMapper::mapFromEntity)
        }
    }
}