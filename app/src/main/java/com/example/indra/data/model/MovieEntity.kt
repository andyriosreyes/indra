package com.example.indra.data.model

import com.google.gson.annotations.SerializedName

data class MovieEntity (
    @SerializedName("id") val id: Int,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("vote_average") val vote_average: String,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("overview") val overview: String
//    @SerializedName("title") val title: String,
//    @SerializedName("vote_average") val vote_average: String,
//    @SerializedName("release_date") val release_date: String,
//    @SerializedName("overview") val overview: String,
)