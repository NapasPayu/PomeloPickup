package com.pomelofashion.pomelopickup.presentation.pickuplocationlist.di

import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.PickupLocationListViewModel
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.mapper.PickupLocationViewMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featurePickupLocationListModule = module {
    single { PickupLocationViewMapper() }
    viewModel { PickupLocationListViewModel(get(), get(), get()) }
}