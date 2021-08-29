package com.pomelofashion.pomelopickup.presentation.common

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.pomelofashion.pomelopickup.presentation.common.model.AlertEvent
import com.pomelofashion.pomelopickup.presentation.common.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val loadingEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertEvent by lazy { SingleLiveEvent<AlertEvent>() }

    protected fun alert(message: String? = null, @StringRes messageRes: Int? = null) {
        alertEvent.value = AlertEvent(
            message = message,
            messageRes = messageRes
        )
    }

    protected fun showLoading() {
        loadingEvent.value = true
    }

    protected fun hideLoading() {
        loadingEvent.value = false
    }
}