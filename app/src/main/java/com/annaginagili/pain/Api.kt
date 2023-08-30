package com.annaginagili.pain

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun getProducts(): Call<Products>
}