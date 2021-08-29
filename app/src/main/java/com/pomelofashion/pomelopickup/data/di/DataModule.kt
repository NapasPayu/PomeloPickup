package com.pomelofashion.pomelopickup.data.di

import com.google.android.gms.location.LocationServices
import com.pomelofashion.pomelopickup.BuildConfig
import com.pomelofashion.pomelopickup.data.mapper.LocationMapper
import com.pomelofashion.pomelopickup.data.mapper.PickupLocationMapper
import com.pomelofashion.pomelopickup.data.remote.PickupLocationService
import com.pomelofashion.pomelopickup.data.repository.LocationRepositoryImpl
import com.pomelofashion.pomelopickup.data.repository.PickupLocationRepositoryImpl
import com.pomelofashion.pomelopickup.domain.repository.LocationRepository
import com.pomelofashion.pomelopickup.domain.repository.PickupLocationRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    // mapper
    single { PickupLocationMapper() }
    single { LocationMapper() }

    // remote
    single { OkHttpClient.Builder().build() }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(PickupLocationService::class.java) }

    // provider
    single { LocationServices.getFusedLocationProviderClient(androidContext()) }

    // repository
    single<PickupLocationRepository> { PickupLocationRepositoryImpl(get(), get()) }
    single<LocationRepository> { LocationRepositoryImpl(get(), get()) }
}
