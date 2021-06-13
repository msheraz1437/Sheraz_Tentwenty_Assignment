package com.example.sheraz.repository.model.details

import com.google.gson.annotations.SerializedName


data class MovieDetail(
        @SerializedName("id") var id: Int = 0,
        @SerializedName("genres") var genres: List<Genres> = emptyList(),
        @SerializedName("overview") var overview: String = "",
        @SerializedName("title") var title: String = "",
        @SerializedName("release_date") var releaseDate: String = ""
)