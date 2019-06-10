package com.iyoa.cleanaddis.viewModels.teaching

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.CategoryDatabase
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.CategoryDAO
import com.iyoa.cleanaddis.repository.common.CategoryRepos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TeachingViewModel(application: Application):AndroidViewModel(application) {
   /*
    private val categoryTitle:LiveData<String> = MutableLivedata<String>()
    private val categoryList:LiveData<String> = MutableLivedata<String>()

    private val categoryRepos: CategoryRepos
    val allArticles : LiveData<List<Category>>

    init{
        val  articleDAO = CategoryDatabase.getCategoryDatabase(application).categoryDao()
        categoryRepos = CategoryRepos(CategoryDAO)
        allArticles = categoryRepos.allCategories()
    }


    fun insertCategory(category:Category) = viewModelScope.launch(Dispatchers.IO)
    {
        categoryRepos.insertCategory(category)
    }

    fun getCatagories() = viewModelScope.launch(Dispatchers.IO) {
        categoryRepos.allCategories()
    }

    fun addCatagories(article:List<Category>) = viewModelScope.launch(Dispatchers.IO) {
        categoryRepos.insertCategory(category)
    }

*/
}