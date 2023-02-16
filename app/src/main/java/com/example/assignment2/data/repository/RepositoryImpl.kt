package com.example.assignment2.data.repository

import com.example.assignment2.data.model.people.PeopleModel
import com.example.assignment2.data.model.room.RoomModel
import com.example.assignment2.data.remote.ApiDetails
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiDetails: ApiDetails
) : Repository {

    override suspend fun getPeopleList(): Response<PeopleModel> {
        return apiDetails.getPeopleList()
    }

    override suspend fun getRoomsList(): Response<RoomModel> {
        TODO("Not yet implemented")
    }
}