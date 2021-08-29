package com.pomelofashion.pomelopickup.data.mapper

import com.pomelofashion.pomelopickup.data.model.PickupLocationEntity
import com.pomelofashion.pomelopickup.domain.model.PickupLocation

class PickupLocationMapper : Mapper<PickupLocationEntity, PickupLocation> {

    override fun mapFromEntity(entity: PickupLocationEntity): PickupLocation {
        return with(entity) {
            PickupLocation(
                feature = feature ?: "",
                idPickupLocation = idPickupLocation ?: 0,
                idCountry = idCountry,
                idState = idState ?: 0,
                idCarrier = idCarrier,
                company = company ?: "",
                npsLink = npsLink ?: "",
                alias = alias,
                address1 = address1,
                address2 = address2 ?: "",
                district = district ?: "",
                city = city,
                postcode = postcode ?: 0,
                latitude = latitude ?: 0.0,
                longitude = longitude ?: 0.0,
                phone = phone ?: "",
                nearestBts = nearestBts ?: "",
                notableArea = notableArea ?: "",
                hours1 = hours1 ?: "",
                hours2 = hours2 ?: "",
                hours3 = hours3 ?: "",
                description = description,
                isFeatured = isFeatured,
                subtype = subtype ?: "",
                storeImagePath = storeImagePath ?: "",
                floormapImagePath = floormapImagePath ?: "",
                active = active,
                floorNumber = floorNumber ?: 0,
                status = status,
                idZone = idZone,
                isNewLocation = isNewLocation,
                type = type,
                hours = hours ?: emptyList(),
                isDefaultLocation = isDefaultLocation ?: false
            )
        }
    }
}