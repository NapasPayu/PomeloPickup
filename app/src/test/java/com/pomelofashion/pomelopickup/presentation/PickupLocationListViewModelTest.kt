package com.pomelofashion.pomelopickup.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.pomelofashion.pomelopickup.domain.model.PickupLocation
import com.pomelofashion.pomelopickup.domain.usecase.GetCurrentLocationUseCase
import com.pomelofashion.pomelopickup.domain.usecase.GetPickupLocationsUseCase
import com.pomelofashion.pomelopickup.presentation.common.model.AlertEvent
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.PickupLocationListViewModel
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.mapper.PickupLocationViewMapper
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.model.PickupLocationView
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PickupLocationListViewModelTest {

    private val getPickupLocationsUseCase: GetPickupLocationsUseCase = mockk()
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase = mockk()
    private val pickupLocationViewMapper: PickupLocationViewMapper = mockk()
    private lateinit var viewModel: PickupLocationListViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `get pickup locations successfully`() = runBlockingTest {
        val fakePickupLocations = listOf(
            PickupLocation(
                idPickupLocation = 14,
                alias = "Good Shepherd Crafts & Thrift Sh",
                address1 = "177 Si Sunthon Road Si Sunthon Phuket",
                city = "Phuket"
            )
        )
        val fakePickupLocationView = PickupLocationView(
            id = 14,
            name = "Good Shepherd Crafts & Thrift Sh",
            address = "177 Si Sunthon Road Si Sunthon Phuket",
            city = "Phuket",
            lat = 7.980025,
            long = 98.329915
        )
        val observerPickupLocations: Observer<List<PickupLocationView>> = mockk(relaxed = true)
        coEvery { getPickupLocationsUseCase() } returns Result.success(fakePickupLocations)
        every { pickupLocationViewMapper.mapToView(any()) } returns fakePickupLocationView

        viewModel = PickupLocationListViewModel(
            getPickupLocationsUseCase,
            getCurrentLocationUseCase,
            pickupLocationViewMapper
        )
        viewModel.pickupLocations.observeForever(observerPickupLocations)

        verify {
            observerPickupLocations.onChanged(listOf(fakePickupLocationView))
        }
    }

    @Test
    fun `get pickup locations failed`() = runBlockingTest {
        val fakePickupLocationView = PickupLocationView(
            id = 14,
            name = "Good Shepherd Crafts & Thrift Sh",
            address = "177 Si Sunthon Road Si Sunthon Phuket",
            city = "Phuket",
            lat = 7.980025,
            long = 98.329915
        )
        val observerAlertEvent: Observer<AlertEvent> = mockk(relaxed = true)
        coEvery { getPickupLocationsUseCase() } returns Result.failure(Throwable("error"))
        every { pickupLocationViewMapper.mapToView(any()) } returns fakePickupLocationView

        viewModel = PickupLocationListViewModel(
            getPickupLocationsUseCase,
            getCurrentLocationUseCase,
            pickupLocationViewMapper
        )
        viewModel.alertEvent.observeForever(observerAlertEvent)

        verify {
            observerAlertEvent.onChanged(AlertEvent(message = "error"))
        }
    }
}