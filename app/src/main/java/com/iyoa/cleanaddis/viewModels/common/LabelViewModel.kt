package com.iyoa.cleanaddis.viewModels.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.LabelDatabase
import com.iyoa.cleanaddis.data.posting.LabelUUID
import com.iyoa.cleanaddis.repository.common.LabelRepository
import com.iyoa.cleanaddis.retrofitEden.LabelServiceImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class LabelViewModel (application: Application): AndroidViewModel(application) {
    private val labelRepos: LabelRepository
    private val labelServiceImpl: LabelServiceImpl

    init {
        val labelDao = LabelDatabase.getLabelDatabase(application).labelDao()
        labelRepos = LabelRepository(labelDao)
        labelServiceImpl = LabelServiceImpl()
    }


    private val _getResponse = MutableLiveData<Response<LabelUUID>>()
    val getResponse: LiveData<Response<LabelUUID>>
        get() = _getResponse

    fun getLabelByName(labelName: String) = viewModelScope.launch {
        _getResponse.postValue(labelServiceImpl.getLabelByName(labelName))
    }
}
