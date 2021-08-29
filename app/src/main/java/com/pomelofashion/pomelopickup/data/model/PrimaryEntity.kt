package com.pomelofashion.pomelopickup.data.model

import com.google.gson.annotations.SerializedName

data class PrimaryEntity(
    val landscape: String?,
    @SerializedName("full_landscape")
    val fullLandscape: String?,
    val portrait: String?,
    @SerializedName("full_portrait")
    val fullPortrait: String?,
)