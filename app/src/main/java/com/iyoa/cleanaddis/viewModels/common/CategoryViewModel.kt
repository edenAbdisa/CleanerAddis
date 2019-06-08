package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.CategoryDatabase
import com.iyoa.cleanaddis.connectDatabase.news.MediaDatabase
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.repository.common.CategoryRepos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application):AndroidViewModel(application) {
    private val categoryRepos: CategoryRepos
    val allCategory : LiveData<List<Category>>


    init{
        val  categoryDao = CategoryDatabase.getCategoryDatabase(application).categoryDao()
        categoryRepos = CategoryRepos(categoryDao)
        allCategory = categoryRepos.allCategories()
    }


    fun insertMedia(category: Category) = viewModelScope.launch(Dispatchers.IO)
    {
        categoryRepos.insertMedia(category)
    }

}