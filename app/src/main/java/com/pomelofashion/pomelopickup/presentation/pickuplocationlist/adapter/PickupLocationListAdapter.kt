package com.pomelofashion.pomelopickup.presentation.pickuplocationlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pomelofashion.pomelopickup.databinding.PickupLocationItemBinding
import com.pomelofashion.pomelopickup.presentation.pickuplocationlist.model.PickupLocationView

class PickupLocationListAdapter :
    ListAdapter<PickupLocationView, PickupLocationListAdapter.ViewHolder>(PickupLocationDiffCallback) {

    inner class ViewHolder(private val binding: PickupLocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pickupLocationView: PickupLocationView) {
            binding.pickupLocation = pickupLocationView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PickupLocationItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object PickupLocationDiffCallback : DiffUtil.ItemCallback<PickupLocationView>() {
    override fun areItemsTheSame(
        oldItem: PickupLocationView,
        newItem: PickupLocationView,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PickupLocationView,
        newItem: PickupLocationView,
    ): Boolean {
        return oldItem.id == newItem.id
    }
}