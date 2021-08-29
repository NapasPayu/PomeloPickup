package com.pomelofashion.pomelopickup.domain

import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.domain.repository.PickupLocationRepository
import com.pomelofashion.pomelopickup.domain.usecase.GetPickupLocationsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPickupLocationsUseCaseTest {

    private val pickupLocationRepository: PickupLocationRepository = mockk()
    private val getPickupLocationsUseCase = GetPickupLocationsUseCase(pickupLocationRepository)

    @Test
    fun `get pickup locations with successful repository`() = runBlockingTest {
        coEvery { pickupLocationRepository.getPickupLocations() } returns Result.success(listOf(
            PickupLocation()))

        val result = getPickupLocationsUseCase()

        assertTrue(result.isSuccess && result.getOrNull() != null)
    }

    @Test
    fun `get pickup locations with failed repository`() = runBlockingTest {
        coEvery { pickupLocationRepository.getPickupLocations() } returns Result.failure(Exception())

        val result = getPickupLocationsUseCase()

        assertTrue(result.isFailure && result.getOrNull() == null)
    }
}