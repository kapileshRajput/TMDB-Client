package com.rajputkapilesh.tmdbclient.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "popular_tvShows")
data class TvShow(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Int?,
    @SerializedName("vote_count")
    val voteCount: Int?
)