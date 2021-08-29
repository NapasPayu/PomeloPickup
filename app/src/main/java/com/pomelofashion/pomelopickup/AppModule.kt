package com.pomelofashion.pomelopickup

import com.pomelofashion.pomelopickup.data.di.dataModule
import com.pomelofashion.pomelopickup.domain.di.domainModule
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.di.featurePickupLocationListModule

val appModule = listOf(
    dataModule,
    domainModule,
    featurePickupLocationListModule
)