package com.pomelofashion.pomelopickup.domain.di

import com.pomelofashion.pomelopickup.domain.usecase.GetCurrentLocationUseCase
import com.pomelofashion.pomelopickup.domain.usecase.GetPickupLocationsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetPickupLocationsUseCase(get()) }
    single { GetCurrentLocationUseCase(get()) }
}