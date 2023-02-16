package com.example.assignment2.data.repository

import com.example.assignment2.data.model.people.PeopleModel
import com.example.assignment2.data.model.room.RoomModel
import retrofit2.Response
import retrofit2.http.GET

interface Repository {

   suspend fun getPeopleList(): Response<PeopleModel>


   suspend fun getRoomsList(): Response<RoomModel>
}