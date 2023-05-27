package com.application.roompractice.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.application.roompractice.db.Entity.NumberEntity
import com.application.roompractice.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()


    lateinit var numberEntityList : LiveData<List<NumberEntity>>


    fun create(numberEntity: NumberEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.create(numberEntity)

    }

    fun read() {

        numberEntityList = repository.read().asLiveData()

    }

    fun update(numberEntity: NumberEntity) = viewModelScope.launch (Dispatchers.IO){

        val ranNumber = (0..100).random().toString()
        numberEntity.randomNumber = "updated : $ranNumber"

        repository.update(numberEntity)


    }

    fun delete(numberEntity: NumberEntity)  =viewModelScope.launch(Dispatchers.IO){

        repository.delete(numberEntity)

    }


}