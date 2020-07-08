package com.mitocode.taller1.response

import com.google.gson.annotations.SerializedName

class PhotoResponse(
    var id: Int,
    @SerializedName("title")
    var titulo: String?,
    var url: String?
) {
}