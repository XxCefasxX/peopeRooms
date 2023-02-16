package com.example.assignment2.data.remote

import com.example.assignment2.data.model.people.PeopleModel
import com.example.assignment2.data.model.room.RoomModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {

    @GET(ApiReference.PEOPLE)
    suspend fun getPeopleList(): Response<PeopleModel>

    @GET(ApiReference.ROOM)
    suspend fun getRoomList(): Response<RoomModel>

}