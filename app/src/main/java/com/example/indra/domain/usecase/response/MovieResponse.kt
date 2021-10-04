package com.example.indra.domain.usecase.response

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "TableMovie")
@Parcelize
data class MovieResponse(
    @PrimaryKey var id: Int,
    var poster_path: String,
    var vote_average: String,
    var title: String,
    var release_date: String,
    var overview: String
):Parcelable {
}