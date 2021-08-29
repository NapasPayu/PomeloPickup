package com.pomelofashion.pomelopickup.presentation.mapper

import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.mapper.PickupLocationViewMapper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PickupLocationViewMapperTest {

    private lateinit var pickupLocationViewMapper: PickupLocationViewMapper

    @Before
    fun setup() {
        pickupLocationViewMapper = PickupLocationViewMapper()
    }

    @Test
    fun `map from entity`() {
        val pickupLocation = PickupLocation(
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
            status = "active"
        )

        val pickupLocationView = pickupLocationViewMapper.mapToView(pickupLocation)

        assertEquals(pickupLocationView.id, pickupLocation.idPickupLocation)
        assertEquals(pickupLocationView.name, pickupLocation.alias)
        assertEquals(pickupLocationView.address, pickupLocation.address1)
    }
}