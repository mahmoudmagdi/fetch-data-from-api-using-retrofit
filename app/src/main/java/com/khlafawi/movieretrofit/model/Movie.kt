package com.khlafawi.movieretrofit.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

// TODO: STEP(5): create the model classes that retrofit functions receives
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

@Parcelize
@JsonClass(generateAdapter = true)
data class MoviesResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Movie>,

    @SerializedName("total_results")
    val total_results: Int,

    @SerializedName("total_pages")
    val total_pages: Int
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
// TODO: STEP(5): create the model classes that retrofit functions receives
