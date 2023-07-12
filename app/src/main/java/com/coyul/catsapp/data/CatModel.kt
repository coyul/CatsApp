package com.coyul.catsapp.data

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("country_code") val country_code: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: Image?
)

data class Image(@SerializedName("url") val url: String?)