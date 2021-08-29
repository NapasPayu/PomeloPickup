package com.pomelofashion.pomelopickup.presentation.pickuplocationlist.model

import android.location.Location
import com.pomelofashion.pomelopickup.domain.model.LatLng

data class PickupLocationView(
    val id: Int,
    val name: String,
    val city: String,
    val address: String,
    val lat: Double,
    val long: Double,
    val distance: Float? = null,
) {
    fun distanceTo(currentLatLng: LatLng): Float {
        val destLocation = Location("destLocation").apply {
            latitude = lat
            longitude = long
        }
        val currentLocation = Location("currentLocation").apply {
            latitude = currentLatLng.latitude
            longitude = currentLatLng.longitude
        }
        return destLocation.distanceTo(currentLocation)
    }
}