package com.iyoa.cleanaddis.repository.common

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.CategoryDAO

class CategoryRepos(val categoryDAO: CategoryDAO) {
    fun allCategories(): LiveData<List<Category>> = categoryDAO.getAllCategory()

    fun insertMedia(category: Category){
        categoryDAO.insertCategory(category)
    }

}