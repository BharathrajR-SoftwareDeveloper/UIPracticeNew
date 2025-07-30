package com.example.uipractice.Pagination.api.model

data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

data class Product(
    val id: Int,
    val title: String,
    val price: Int,
    val thumbnail: String
)
