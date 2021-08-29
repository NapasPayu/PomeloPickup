package com.pomelofashion.pomelopickup.data.repository

import com.pomelofashion.pomelopickup.data.mapper.PickupLocationMapper
import com.pomelofashion.pomelopickup.data.model.PickupLocationEntity
import com.pomelofashion.pomelopickup.data.model.PickupLocationResponseEntity
import com.pomelofashion.pomelopickup.data.remote.PickupLocationService
import com.pomelofashion.pomelopickup.domain.repository.PickupLocationRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Test

@ExperimentalCoroutinesApi
class PickupLocationRepositoryTest {

    private val pickupLocationService: PickupLocationService = mockk()
    private val pickupLocationMapper: PickupLocationMapper = mockk(relaxed = true)
    private val pickupLocationRepository: PickupLocationRepository =
        PickupLocationRepositoryImpl(pickupLocationService, pickupLocationMapper)

    @Test
    fun `get pickup locations with successful service`() = runBlockingTest {
        coEvery { pickupLocationService.getPickupLocations(any()) } returns PickupLocationResponseEntity(
            numberOfNewLocations = 5,
            pickup = listOf(
                PickupLocationEntity(
                    idPickupLocation = 14,
                    idCountry = 206,
                    idState = 360,
                    idCarrier = 23,
                    alias = "Good Shepherd Crafts & Thrift Sh",
                    address1 = "177 Si Sunthon Road Si Sunthon Phuket",
                    address2 = "Located in the Wana Business Park",
                    city = "Phuket",
                    postcode = 83110,
                    latitude = 15.17352,
                    longitude = 98.359504,
                    phone = "084-412-5443",
                    active = true,
                    status = "active",
                    feature = null,
                    company = null,
                    npsLink = null,
                    district = null,
                    nearestBts = null,
                    notableArea = null,
                    hours1 = null,
                    hours2 = null,
                    hours3 = null,
                    subtype = null,
                    storeImagePath = null,
                    floormapImagePath = null,
                    floorNumber = null,
                    features = null,
                    hours = null,
                    images = null,
                    isDefaultLocation = null,
                    description = "",
                    isFeatured = false,
                    idZone = 111,
                    isNewLocation = false,
                    type = "pickup"
                )
            )
        )

        val result = pickupLocationRepository.getPickupLocations()

        assertTrue(result.isSuccess)
    }

    @Test
    fun `get pickup locations with failed service`() = runBlockingTest {
        coEvery { pickupLocationService.getPickupLocations(any()) } throws Exception()

        val result = pickupLocationRepository.getPickupLocations()

        assertTrue(result.isFailure)
    }
}