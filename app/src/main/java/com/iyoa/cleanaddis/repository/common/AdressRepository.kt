package com.iyoa.cleanaddis.repository.common

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Address
import com.iyoa.cleanaddis.data.common.AddressDAO

class AddressRepository(private val  addressDAO: AddressDAO) {

    fun getAddressByUuid(UUID:Long):LiveData<Address> = addressDAO.getAddressByUUID(UUID)

    fun insertAddress(address: Address) = addressDAO.insertAddress(address)




}