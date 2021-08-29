package com.pomelofashion.pomelopickup.presentation.common.model

import androidx.annotation.StringRes

data class AlertEvent(
    val message: String? = null,
    @StringRes val messageRes: Int? = null,
)