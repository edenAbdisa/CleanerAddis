package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.CategoryDatabase
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.repository.common.CategoryRepos
import com.iyoa.cleanaddis.retrofitEden.CategoryServiceImpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CategoryViewModel(application: Application):AndroidViewModel(application) {
    private val categoryRepos: CategoryRepos
    private val categoryServiceImpl: CategoryServiceImpl
    val allCategory : LiveData<List<Category>>


    init{
        val  categoryDao = CategoryDatabase.getCategoryDatabase(application).categoryDao()
        categoryRepos = CategoryRepos(categoryDao)
        categoryServiceImpl= CategoryServiceImpl()
        allCategory = categoryRepos.allCategories()
    }


    private val _getResponse = MutableLiveData<Response<Category>>()
    val getResponse: LiveData<Response<Category>>
        get() = _getResponse
    fun getCategoryByName(categoryName:String) = viewModelScope.launch{
        _getResponse.postValue(categoryServiceImpl.getCategoryByName(categoryName))
    }

}