package com.iyoa.cleanaddis.data.posting

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.entity.posting.Friend
import com.iyoa.cleanaddis.entity.posting.Post
import java.util.*

@Dao
interface FriendDAO {
    @Query("SELECT * FROM friend WHERE uuid =:uuid")
    fun getFriendByUUID(uuid: String): LiveData<Friend>

    @Query("SELECT * FROM friend")
    fun getAllFriend(): LiveData<List<Friend>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFriend(friend: Friend)

    @Update
    fun updateFriend(friend: Friend)

    @Delete
    fun deleteFriend(friend: Friend)

    @Query("DELETE FROM friend")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFriends(listOfFriend: List<Friend>)
}