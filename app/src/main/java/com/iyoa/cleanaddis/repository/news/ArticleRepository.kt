package com.iyoa.cleanaddis.repository.news

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO

class ArticleRepository(private val articleDAO: ArticleDAO) {
    fun allArticles(): LiveData<List<Article>> = articleDAO.getAllNews()

    fun insertArticles(article: Article){
        articleDAO.insertNews(article)
    }
}