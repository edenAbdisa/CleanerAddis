package com.iyoa.cleanaddis.data.posting

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "label")
class LabelUUID ( @PrimaryKey
                  val uuid:String,
                  val labelName:String){
}