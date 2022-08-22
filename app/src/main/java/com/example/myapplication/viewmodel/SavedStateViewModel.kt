package com.example.myapplication.viewmodel

import androidx.lifecycle.*

class SavedStateViewModel(private val savedStateHandle:SavedStateHandle): ViewModel(){

    private val _count = savedStateHandle.getLiveData("count",0) //indicate that the value _count will start with the value that
                                                                              // is received by the savedStateHandle and in case be null will start with a value of 0
    val count: LiveData<Int> get() = _count

    fun incrementCount(){
        _count.value = _count.value!! +1
    }


    class Factory(val savedStateHandle: SavedStateHandle): ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SavedStateViewModel(savedStateHandle) as T
        }
    }





}