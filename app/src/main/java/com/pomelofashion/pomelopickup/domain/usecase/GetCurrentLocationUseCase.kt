package com.pomelofashion.pomelopickup.domain.usecase

import com.pomelofashion.pomelopickup.domain.model.LatLng
import com.pomelofashion.pomelopickup.domain.repository.LocationRepository

class GetCurrentLocationUseCase(private val locationRepository: LocationRepository) {
    suspend operator fun invoke(): Result<LatLng> = locationRepository.getCurrentLocation()
}