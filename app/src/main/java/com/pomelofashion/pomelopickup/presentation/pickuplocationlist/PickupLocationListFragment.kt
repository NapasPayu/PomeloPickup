package com.pomelofashion.pomelopickup.presentation.pickuplocationlist

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.pomelofashion.pomelopickup.R
import com.pomelofashion.pomelopickup.databinding.FragmentPickupLocationListBinding
import com.pomelofashion.pomelopickup.presentation.common.BaseFragment
import com.pomelofashion.pomelopickup.presentation.common.model.AlertEvent
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.adapter.PickupLocationListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PickupLocationListFragment : BaseFragment() {

    private lateinit var binding: FragmentPickupLocationListBinding
    private val viewModel: PickupLocationListViewModel by viewModel()
    private val listAdapter by lazy { PickupLocationListAdapter() }
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                viewModel.getCurrentLocation()
            } else {
                showAlert(AlertEvent(messageRes = R.string.location_permission_not_granted_message))
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPickupLocationListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = listAdapter
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_current_location -> {
                    requestPermissionIfNeeded()
                    true
                }
                else -> false
            }
        }

        viewModel.pickupLocations.observe(viewLifecycleOwner) {
            it?.let {
                listAdapter.submitList(it)
            }
        }

        viewModel.alertEvent.observe(viewLifecycleOwner) {
            it?.let {
                showAlert(it)
            }
        }
    }

    private fun requestPermissionIfNeeded() {
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            viewModel.getCurrentLocation()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}

