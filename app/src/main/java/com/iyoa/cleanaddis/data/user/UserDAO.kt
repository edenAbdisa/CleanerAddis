package com.iyoa.cleanaddis.data.user

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDAO {
    @Query("SELECT * FROM user WHERE username =:name")
    fun findUserByUsername(name: String): User
}