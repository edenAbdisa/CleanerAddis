package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.repository.news.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleDetailViewModel(
    application: Application,articleID:Long

) : AndroidViewModel(application) {

    private val articleRepos: ArticleRepository
    val title:String
    val text:String
    val article:Article
    val allArticles : LiveData<List<Article>>

    init{
        val  articleDAO = ArticleDatabase.getArticleDatabase(application).articleDao()
        articleRepos = ArticleRepository(articleDAO)
        allArticles = articleRepos.allArticles()
        article = articleRepos.getArticle(articleID.toString()) as Article
        title = article.title
        text = article.text
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