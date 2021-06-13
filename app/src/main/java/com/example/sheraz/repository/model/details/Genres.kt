package com.example.sheraz.repository.model.details

import com.google.gson.annotations.SerializedName


/**
 * Created by Sheraz on 08,November,2019
 */

data class Genres(
        @SerializedName("id") var id: Int = 0,
        @SerializedName("name") var name: String = ""
)