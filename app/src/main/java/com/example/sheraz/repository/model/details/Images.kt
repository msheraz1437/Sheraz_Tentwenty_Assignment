package com.example.sheraz.repository.model.details

import com.google.gson.annotations.SerializedName


data class Images(
        @SerializedName("id") var id: Int = 0,
        @SerializedName("posters") var posters: List<Posters> = emptyList()
)