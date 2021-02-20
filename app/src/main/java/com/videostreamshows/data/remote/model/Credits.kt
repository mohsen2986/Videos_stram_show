package com.videostreamshows.data.remote.model
import com.google.gson.annotations.SerializedName


data class Credits(
    @SerializedName("cast")
    val cast: List<Cast>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int // 44217
)

data class Cast(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("character")
    val character: String, // Bjorn Lothbrok
    @SerializedName("credit_id")
    val creditId: String, // 543df5ee0e0a266f8e001347
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 23498
    @SerializedName("known_for_department")
    val knownForDepartment: String, // Acting
    @SerializedName("name")
    val name: String, // Alexander Ludwig
    @SerializedName("order")
    val order: Int, // 1
    @SerializedName("original_name")
    val originalName: String, // Alexander Ludwig
    @SerializedName("popularity")
    val popularity: Double, // 6.623
    @SerializedName("profile_path")
    val profilePath: String // /unP5YUgEdECL2gMLs0zCNya6is6.jpg
)

data class Crew(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("credit_id")
    val creditId: String, // 57ac7eca92514157f100248d
    @SerializedName("department")
    val department: String, // Production
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 37631
    @SerializedName("job")
    val job: String, // Executive Producer
    @SerializedName("known_for_department")
    val knownForDepartment: String, // Writing
    @SerializedName("name")
    val name: String, // Michael Hirst
    @SerializedName("original_name")
    val originalName: String, // Michael Hirst
    @SerializedName("popularity")
    val popularity: Double, // 1.8
    @SerializedName("profile_path")
    val profilePath: Any // null
)