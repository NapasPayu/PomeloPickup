package com.pomelofashion.pomelopickup.data.mapper

import com.pomelofashion.pomelopickup.data.model.PickupLocationEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PickupLocationMapperTest {

    private lateinit var pickupLocationMapper: PickupLocationMapper

    @Before
    fun setup() {
        pickupLocationMapper = PickupLocationMapper()
    }

    @Test
    fun `map from entity`() {
        val pickupLocationEntity = PickupLocationEntity(
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

        val pickupLocation = pickupLocationMapper.mapFromEntity(pickupLocationEntity)

        assertEquals(pickupLocationEntity.idPickupLocation, pickupLocation.idPickupLocation)
        assertEquals(pickupLocationEntity.alias, pickupLocation.alias)
        assertEquals(pickupLocationEntity.address1, pickupLocation.address1)
    }
}