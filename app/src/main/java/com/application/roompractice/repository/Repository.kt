package com.application.roompractice.repository

import com.application.roompractice.MyApp
import com.application.roompractice.db.Entity.NumberEntity
import com.application.roompractice.db.MyDatabase

class Repository {


    // CRUD
    private val context = MyApp.context()
    private val db = MyDatabase.getDatabase(context)

    fun create(numberEntity: NumberEntity) = db.numberDao().create(numberEntity)

    fun read() = db.numberDao().read()

    fun update(numberEntity: NumberEntity) = db.numberDao().update(numberEntity)

    fun delete(numberEntity: NumberEntity) = db.numberDao().delete(numberEntity)


}