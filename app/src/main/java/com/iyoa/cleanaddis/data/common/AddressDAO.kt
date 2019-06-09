package com.iyoa.cleanaddis.data.common

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AddressDAO {
    @Query("SELECT * FROM Address WHERE uuid =:uuid")
    fun getAddressByUUID(uuid: Long): LiveData<Address>


    @Query("SELECT * FROM Address")
    fun getAllCategory(): LiveData<List<Address>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(address: Address)

    @Update
    fun updateAddress(address: Address)

    @Delete
    fun deleteAddress(address: Address)
}