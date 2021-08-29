package com.pomelofashion.pomelopickup.data.model

import com.google.gson.annotations.SerializedName

data class StoreEntity(
    val primary: PrimaryEntity?,
    val secondary: String?,
    @SerializedName("full_secondary")
    val fullSecondary: String?,
)