package com.muhsanjaved.api_practice.models

// Step 2
data class MyData(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)