package com.pomelofashion.pomelopickup.presentation.pickuplocationlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.domain.usecase.GetCurrentLocationUseCase
import com.pomelofashion.pomelopickup.domain.usecase.GetPickupLocationsUseCase
import com.pomelofashion.pomelopickup.presentation.common.BaseViewModel
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.mapper.PickupLocationViewMapper
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.model.PickupLocationView
import kotlinx.coroutines.launch

class PickupLocationListViewModel(
    private val getPickupLocationsUseCase: GetPickupLocationsUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase,
    private val pickupLocationViewMapper: PickupLocationViewMapper,
) : BaseViewModel() {

    val pickupLocations = MutableLiveData<List<PickupLocationView>>()

    init {
        showLoading()
        viewModelScope.launch {
            getPickupLocationsUseCase()
                .onSuccess { locations ->
                    pickupLocations.value = locations
                        .filter(PickupLocation::isDataValid)
                        .map(pickupLocationViewMapper::mapToView)
                }
                .onFailure {
                    alert(message = it.message)
                }
            hideLoading()
        }
    }

    fun getCurrentLocation() {
        showLoading()
        viewModelScope.launch {
            getCurrentLocationUseCase()
                .onSuccess { latLong ->
                    pickupLocations.value = pickupLocations.value?.map {
                        it.copy(distance = it.distanceTo(latLong))
                    }?.sortedBy {
                        it.distance
                    }
                }
                .onFailure {
                    alert(message = it.message)
                }
            hideLoading()
        }
    }
}