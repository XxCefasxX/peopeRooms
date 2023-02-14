package com.example.assignment2.data.model.people


import com.google.gson.annotations.SerializedName

data class ModelData(
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("body")
    val body: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("toId")
    val toId: String? = "",
    @SerializedName("fromId")
    val fromId: String? = "",
    @SerializedName("meetingid")
    val meetingid: String? = ""
)