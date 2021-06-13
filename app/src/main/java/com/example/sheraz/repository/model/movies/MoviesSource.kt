package com.example.sheraz.repository.model.movies

import com.google.gson.annotations.SerializedName


/**
 * Created by Sheraz on 04,November,2019
 */


data class MoviesSource(
        @SerializedName("page") var page: Int = 0,
        @SerializedName("results") var results: List<Movies> = emptyList(),
        @SerializedName("total_pages") var total_pages: Int = 0,
        @SerializedName("total_results") var total_results: Int = 0
)

