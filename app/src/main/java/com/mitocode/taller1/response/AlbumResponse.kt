package com.mitocode.taller1.response

import com.google.gson.annotations.SerializedName

class AlbumResponse(
    @SerializedName("userId")
    var usuarioId: Int,
    var id: Int,
    var title: String?
) {
}