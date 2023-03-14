package com.muhsanjaved.api_practice

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    // Step 1
    @GET("products")
    fun getProductData() : Call<MyData>

}