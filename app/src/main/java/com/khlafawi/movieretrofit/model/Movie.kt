package com.khlafawi.movieretrofit.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movies_table")
@Parcelize
@JsonClass(generateAdapter = true)
data class Movie(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String,

    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val poster_path: String,

    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String
) : Parcelable

fun List<Movie>.asDatabaseModel(): Array<Movie> {
    return map {
        Movie(
            id = it.id,
            title = it.title,
            overview = it.overview,
            poster_path = it.poster_path
        )
    }.toTypedArray()
}