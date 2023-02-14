package com.example.assignment2.data.model.room


import com.google.gson.annotations.SerializedName

data class ModelRoomItem(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean? = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int? = 0,
    @SerializedName("id")
    val id: String? = ""
)