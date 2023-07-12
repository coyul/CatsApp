package com.coyul.catsapp.data

import com.google.gson.annotations.SerializedName

// The model has more values than needed for UI right now to show the possible room for improvement
// and the reason why it is wise to at least have separate DTOs for API and UI layer
// (ideally each layer should have its own DTO, but ut will be overhead for our simple app)
data class CatModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("country_code") val country_code: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: Image?
)

data class Image(@SerializedName("url") val url: String?)