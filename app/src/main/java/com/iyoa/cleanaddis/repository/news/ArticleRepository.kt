package com.iyoa.cleanaddis.repository.news

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.news.ArticleData

class ArticleRepository(private val articleDAO: ArticleDAO) {
    fun allArticles(): LiveData<List<Article>> = articleDAO.getAllNews()

    fun insertArticles(article: Article){
        articleDAO.insertArticle(article)
    }

    fun addArticles(listOfarticles: List<Article>) {
        articleDAO.addArticles(listOfarticles)
    }

    fun getArticle(uuid:Long):LiveData<Article>{

        return articleDAO.getNewsByUuid(uuid)
    }
}