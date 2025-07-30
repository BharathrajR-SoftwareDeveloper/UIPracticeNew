package com.example.uipractice.Pagination.api

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uipractice.Pagination.api.model.Product
import com.example.uipractice.databinding.ItemProductBinding

class ProductAdapter : PagingDataAdapter<Product, ProductAdapter.ProductViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        }
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.title.text = product.title
            binding.price.text = "₹ ${product.price}"
            Glide.with(binding.thumbnail).load(product.thumbnail).into(binding.thumbnail)
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        product?.let { holder.bind(it) }
        product?.let { Log.d("ProductAdapter", "Binding: ${it.title}") }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }
}