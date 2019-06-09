package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleData
import com.iyoa.cleanaddis.repository.news.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class ArticleViewModel(application: Application):AndroidViewModel(application) {
    private val title:LiveData<String> = MutableLiveData<String>()
    private val imageUrl:LiveData<String> = MutableLiveData<String>()
    private val text:LiveData<String> = MutableLiveData<String>()
    private val date:LiveData<Date> = MutableLiveData<Date>()
    private val viewCount:LiveData<Int> = MutableLiveData<Int>()

    private val articleRepos: ArticleRepository
    val allArticles : LiveData<List<Article>>

    init{
        val  articleDAO = ArticleDatabase.getArticleDatabase(application).articleDao()
        articleRepos = ArticleRepository(articleDAO)
        allArticles = articleRepos.allArticles()
    }


    fun insertArticle(article:Article) = viewModelScope.launch(Dispatchers.IO)
    {
        articleRepos.insertArticles(article)
    }

    fun getArticles() = viewModelScope.launch(Dispatchers.IO) {
        articleRepos.allArticles()
    }

    fun addArticles(article:List<Article>) = viewModelScope.launch(Dispatchers.IO) {
        articleRepos.addArticles(article)
    }

}