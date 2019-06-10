package com.iyoa.cleanaddis.data.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName = "User")
data class UserData(

    @ColumnInfo(name="username") val username:String,
    @ColumnInfo(name = "fName") val firstname:String,
    @ColumnInfo(name = "lName") val lastname:String,
    @ColumnInfo(name = "email") val email:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "phone_no") val phonenumber:String,
    @ColumnInfo(name = "img_url") val imageUrl:String,
    @ColumnInfo(name = "activated") val activated:Int,
    @ColumnInfo(name = "blocked") val blocked:Int,
    @ColumnInfo(name = "last_visit") val lastVisit:Date,
    @ColumnInfo(name = "activated_date") val activatedDate:Date


):Serializable {


}