package com.pomelofashion.pomelopickup.data.model

import com.google.gson.annotations.SerializedName

data class PickupLocationResponseEntity(
    @SerializedName("number_of_new_locations")
    val numberOfNewLocations: Int,
    val pickup: List<PickupLocationEntity>,
)