package com.pomelofashion.pomelopickup.presentation.pickuplocationlist.mapper

import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.presentation.common.mapper.ViewMapper
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.model.PickupLocationView

class PickupLocationViewMapper : ViewMapper<PickupLocation, PickupLocationView> {

    override fun mapToView(type: PickupLocation): PickupLocationView {
        return with(type) {
            PickupLocationView(
                id = idPickupLocation,
                name = alias,
                city = city,
                address = address1.trim(),
                lat = latitude,
                long = longitude
            )
        }
    }
}