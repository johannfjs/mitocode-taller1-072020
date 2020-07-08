package com.mitocode.taller1.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfiguracionRetrofit {
    companion object {
        fun getConfiguration(): Retrofit? {
            //OkHttp
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
            //https://jsonplaceholder.typicode.com/albums
            //https://jsonplaceholder.typicode.com/photos
        }
    }
}