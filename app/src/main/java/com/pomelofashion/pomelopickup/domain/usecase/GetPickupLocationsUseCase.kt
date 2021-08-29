package com.pomelofashion.pomelopickup.domain.usecase

import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.domain.repository.PickupLocationRepository

class GetPickupLocationsUseCase(private val pickupLocationRepository: PickupLocationRepository) {
    suspend operator fun invoke(): Result<List<PickupLocation>> =
        pickupLocationRepository.getPickupLocations()
}