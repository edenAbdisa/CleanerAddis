package com.iyoa.cleanaddis.data.posting

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LabelDAO {
    @Query("SELECT * FROM label WHERE labelName =:name")
    fun getLabelByName(name: String): LabelUUID
}