package com.mitocode.taller1.net

import com.mitocode.taller1.response.AlbumResponse
import com.mitocode.taller1.response.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET

interface Metodo {
    @GET("albums")
    fun obtenerAlbunes(): Call<ArrayList<AlbumResponse>>

    @GET("photos")
    fun obtenerFotos(): Call<ArrayList<PhotoResponse>>
}