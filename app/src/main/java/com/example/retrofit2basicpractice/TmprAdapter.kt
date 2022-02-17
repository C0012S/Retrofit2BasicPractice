package com.example.retrofit2basicpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2basicpractice.databinding.ItemTmprBinding

class TmprAdapter : ListAdapter<Row, TmprAdapter.TmprViewHolder>(TmprCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TmprViewHolder {
        val binding = ItemTmprBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TmprViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TmprViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TmprViewHolder(private val binding: ItemTmprBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Row) {
            with(binding) {
                tvName.text = item.pUBLHELTHNM
                tvRegion.text = item.sIGUNNM
                tvAddr1.text = item.rEFINEROADNMADDR
                tvAddr2.text = item.rEFINELOTNOADDR
                tvLocation.text = "설치 위치 : ${item.iNSTLLOC}"
            }
        }
    }

    companion object {
        private val TmprCallback = object : DiffUtil.ItemCallback<Row>() {
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }
        }
    }
}