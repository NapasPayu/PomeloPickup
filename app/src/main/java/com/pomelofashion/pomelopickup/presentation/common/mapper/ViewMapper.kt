package com.pomelofashion.pomelopickup.presentation.common.mapper

interface ViewMapper<D, V> {
    fun mapToView(type: D): V
}