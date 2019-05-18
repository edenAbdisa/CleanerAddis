package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.repository.news.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel(application: Application):AndroidViewModel(application) {
    private val articleRepos: ArticleRepository
    val allArticles : LiveData<List<Article>>

    init{
        val  articleDAO = ArticleDatabase.getDatabase(application).newsDao()
        articleRepos = ArticleRepository(articleDAO)
        allArticles = articleRepos.allArticles()
    }

    fun insertArticle(article:Article) = viewModelScope.launch(Dispatchers.IO)
    {
        articleRepos.insertArticles(article)
    }

}