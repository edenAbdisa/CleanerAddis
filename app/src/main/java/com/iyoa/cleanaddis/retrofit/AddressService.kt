package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.data.common.AddressData
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.data.user.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("address/add")
    fun addAddress(address: AddressData): Call<AddressData>

    @GET("address/{uuid}")
    fun getAddressByUuid(@Path("uuid") uuid:Long): Call<AddressData>

}