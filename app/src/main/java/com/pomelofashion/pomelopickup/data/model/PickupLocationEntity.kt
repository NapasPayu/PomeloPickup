package com.pomelofashion.pomelopickup.data.model

import com.google.gson.annotations.SerializedName

data class PickupLocationEntity(
    val feature: String?,
    @SerializedName("id_pickup_location")
    val idPickupLocation: Int?,
    @SerializedName("id_country")
    val idCountry: Int,
    @SerializedName("id_state")
    val idState: Int?,
    @SerializedName("id_carrier")
    val idCarrier: Int,
    val company: String?,
    @SerializedName("nps_link")
    val npsLink: String?,
    val alias: String,
    val address1: String,
    val address2: String?,
    val district: String?,
    val city: String,
    val postcode: Int?,
    val latitude: Double?,
    val longitude: Double?,
    val phone: String?,
    @SerializedName("nearest_bts")
    val nearestBts: String?,
    @SerializedName("notable_area")
    val notableArea: String?,
    val hours1: String?,
    val hours2: String?,
    val hours3: String?,
    val description: String,
    @SerializedName("is_featured")
    val isFeatured: Boolean,
    val subtype: String?,
    @SerializedName("store_image_path")
    val storeImagePath: String?,
    @SerializedName("floormap_image_path")
    val floormapImagePath: String?,
    val active: Boolean,
    @SerializedName("floor_number")
    val floorNumber: Int?,
    val status: String,
    @SerializedName("id_zone")
    val idZone: Int,
    val features: List<FeatureEntity>?,
    @SerializedName("is_new_location")
    val isNewLocation: Boolean,
    val type: String,
    val hours: List<String>?,
    val images: ImageEntity?,
    @SerializedName("is_default_location")
    val isDefaultLocation: Boolean?,
)