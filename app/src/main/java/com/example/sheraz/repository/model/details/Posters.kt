package com.example.sheraz.repository.model.details


import com.google.gson.annotations.SerializedName

data class Posters(
        @SerializedName("aspect_ratio") var aspectRatio: String = "",
        @SerializedName("file_path") var filePath: String = "",
        @SerializedName("height") var height: Int = 0,
        @SerializedName("width") var width: Int = 0,
)