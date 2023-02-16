package com.example.assignment2.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.data.model.room.RoomModel
import com.example.assignment2.data.repository.Repository
import com.example.assignment2.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _result = MutableLiveData<ResponseType<RoomModel>>()
    val result: LiveData<ResponseType<RoomModel>> = _result

    fun getRoomsList() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getRoomsList()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }
}