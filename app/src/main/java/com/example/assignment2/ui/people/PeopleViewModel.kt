package com.example.assignment2.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.data.model.people.PeopleModel
import com.example.assignment2.data.model.people.PeopleModelItemModel
import com.example.assignment2.data.repository.Repository
import com.example.assignment2.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "PeopleViewModel"

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _result = MutableLiveData<ResponseType<PeopleModel>>()
    val result: LiveData<ResponseType<PeopleModel>> = _result

        private var details = PeopleModelItemModel()
    companion object{
    }
    private val _person = MutableLiveData<PeopleModelItemModel>()
    val person: LiveData<PeopleModelItemModel> = _person

    fun getPeopleList() {
        viewModelScope.launch {
            _result.postValue(ResponseType.Loading())
            val response = repository.getPeopleList()
            if (response.isSuccessful) {
                _result.postValue(ResponseType.Success(response.body()!!))
            } else {
                _result.postValue(ResponseType.Error(response.message()))
            }
        }
    }

    fun setDetails(peopleModelItemModel: PeopleModelItemModel) {
        viewModelScope.launch {
            Log.d(TAG, "getDetails: launch")
            //_person.postValue(ResponseType.Loading())
            Log.d(TAG, "getDetails: _person ${_person.value}")
            _person.value = peopleModelItemModel
//            _person.postValue( peopleModelItemModel)
            //_person.postValue(ResponseType.Success(peopleModelItemModel as Details))
            Log.d(TAG, "getDetails: _person assigned ${_person.value}")
            Log.d(TAG, "getDetails: person assigned ${person.value}")
        }
    }

    fun getDetails() {
//        viewModelScope.launch {
//            Log.d(TAG, "getDetails: launch")
//            //_person.postValue(ResponseType.Loading())
//            Log.d(TAG, "getDetails: _person ${_person.value}")
//            _person.value = details
////            _person.postValue( peopleModelItemModel)
//            //_person.postValue(ResponseType.Success(peopleModelItemModel as Details))
//            Log.d(TAG, "getDetails: _person assigned ${_person.value}")
//            Log.d(TAG, "getDetails: person assigned ${person.value}")
//        }
    }

}