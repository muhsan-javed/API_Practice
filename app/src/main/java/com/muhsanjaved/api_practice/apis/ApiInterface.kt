package com.muhsanjaved.api_practice.apis

import com.muhsanjaved.api_practice.models.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    // Step 1
    @GET("products")
    fun getProductData() : Call<MyData>

}