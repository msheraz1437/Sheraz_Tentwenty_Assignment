package com.example.sheraz.repository.model.movies

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by Sheraz on 04,November,2019
 */

@Entity(tableName = "movies_table")
data class Movies(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @SerializedName("adult") var adult: Boolean? = false,
    @SerializedName("title") var title: String? = null,
    @SerializedName("release_date") var releaseDate: String? = null,
    @SerializedName("poster_path") var url: String? = null,
)