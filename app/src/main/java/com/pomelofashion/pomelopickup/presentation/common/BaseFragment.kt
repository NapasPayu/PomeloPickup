package com.pomelofashion.pomelopickup.presentation.common

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.pomelofashion.pomelopickup.R
import com.pomelofashion.pomelopickup.presentation.common.model.AlertEvent

abstract class BaseFragment : Fragment() {

    protected fun showAlert(alertEvent: AlertEvent) {
        view?.let {
            Snackbar.make(
                it,
                alertEvent.message ?: alertEvent.messageRes?.let(this::getString)
                ?: getString(R.string.generic_error),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}