package com.application.roompractice.db.dao

import androidx.room.*
import com.application.roompractice.db.Entity.NumberEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NumberDao {

    //CRUD

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(numberEntity: NumberEntity)


    @Query("SELECT * FROM number_table")
    fun read(): Flow<List<NumberEntity>>


    @Update
    fun update(numberEntity: NumberEntity)

    @Delete
    fun delete(numberEntity: NumberEntity)


}