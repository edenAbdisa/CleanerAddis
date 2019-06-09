package com.iyoa.cleanaddis.repository.teaching

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.CategoryDAO

class TeachingRepository(private val categoryDAO: CategoryDAO) {

    fun allCategory():LiveData<List<Category>> = categoryDAO.getAllCategory()

    fun insertCategory(category: Category){
        categoryDAO.insertCategory(category)
    }



}