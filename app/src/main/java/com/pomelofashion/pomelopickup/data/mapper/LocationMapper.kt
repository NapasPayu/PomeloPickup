package com.pomelofashion.pomelopickup.data.mapper

import android.location.Location
import com.pomelofashion.pomelopickup.domain.model.LatLng

class LocationMapper : Mapper<Location, LatLng> {

    override fun mapFromEntity(entity: Location): LatLng {
        return with(entity) {
            LatLng(
                latitude = latitude,
                longitude = longitude
            )
        }
    }
}