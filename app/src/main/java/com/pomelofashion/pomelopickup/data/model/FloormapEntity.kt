package com.pomelofashion.pomelopickup.data.model

import com.google.gson.annotations.SerializedName

data class FloormapEntity(
    val main: String?,
    @SerializedName("full_main")
    val fullMain: String?,
    val zoomed: String?,
    @SerializedName("full_zoomed")
    val fullZoomed: String?,
)