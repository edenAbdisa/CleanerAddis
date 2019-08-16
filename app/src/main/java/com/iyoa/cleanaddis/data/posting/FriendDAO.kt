package com.iyoa.cleanaddis.data.posting

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendDAO {
    @Query("SELECT * FROM friend WHERE uuid =:uuid")
    fun getFriendByUUID(uuid: String): LiveData<FriendUUID>

    @Query("SELECT * FROM friend")
    fun getAllFriend(): LiveData<List<FriendUUID>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFriend(friendUUID: FriendUUID)

    @Update
    fun updateFriend(friendUUID: FriendUUID)

    @Delete
    fun deleteFriend(friendUUID: FriendUUID)

    @Query("DELETE FROM friend")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFriends(listOfFriendUUID: List<FriendUUID>)
}