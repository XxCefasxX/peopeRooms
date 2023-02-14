package com.example.assignment2.data.model.people


import com.google.gson.annotations.SerializedName

data class ModelPeopleItem(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("firstName")
    val firstName: String? = "",
    @SerializedName("avatar")
    val avatar: String? = "",
    @SerializedName("lastName")
    val lastName: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("jobtitle")
    val jobtitle: String? = "",
    @SerializedName("favouriteColor")
    val favouriteColor: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("data")
    val `data`: ModelData? = ModelData(),
    @SerializedName("to")
    val to: String? = "",
    @SerializedName("fromName")
    val fromName: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("size")
    val size: String? = ""
)