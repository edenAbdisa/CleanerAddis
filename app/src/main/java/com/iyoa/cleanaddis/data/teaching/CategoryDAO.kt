package com.iyoa.cleanaddis.data.teaching

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iyoa.cleanaddis.data.common.Category

@Dao
interface CategoryDAO {

    @Query("SELECT * FROM Category WHERE uuid =:uuid")
    fun getCategoryByUuid(uuid: Long): LiveData<Category>


    @Query("SELECT * FROM Category")
    fun getAllCategory(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category:Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCategories(listOfCategories: List<Category>)




}