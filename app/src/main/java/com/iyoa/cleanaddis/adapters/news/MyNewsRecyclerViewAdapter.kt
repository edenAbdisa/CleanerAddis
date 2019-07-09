package com.iyoa.cleanaddis.adapters.news

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.entity.posting.Post

import kotlinx.android.synthetic.main.fragment_news.view.*
import java.util.*
import android.R
import android.os.Bundle
import androidx.navigation.Navigation
import com.iyoa.cleanaddis.controller.news.ArticleDetailFragment
import com.iyoa.cleanaddis.controller.news.ArticleFragment


class MyNewsRecyclerViewAdapter(val context: Context, private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ArticleViewHolder>() {

    private var articles: List<Article> = emptyList()
    private var itemListen: RecyclerViewClickListener? = null
    private lateinit var contexts:Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater
            .inflate(com.iyoa.cleanaddis.R.layout.fragment_news, parent, false)


        return ArticleViewHolder(recyclerViewItem)
    }
    fun MyNewsRecyclerViewAdapter(context:Context ,  itemListener:RecyclerViewClickListener) {
        contexts = context
        itemListen = itemListener

    }

    internal fun getArticles():List<Article>{
        return articles
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val course: Article = articles.get(position)
        Log.wtf("ArticleLine35",course.text)

        holder.mIdView.text = course.title
        holder.mContentView.text = course.text
        holder.mView.setOnClickListener {
            listener.recyclerViewClicked(articles[position])
        }

    }

    internal fun setArticles(articles:List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
    internal fun setArticlesForApi(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int = articles.size

    inner class ArticleViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {






        val mIdView: TextView = mView.title_news_card
        val mContentView: TextView = mView.subtitle_news_card
        val mViewButton:Button = mView.view_button_news

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }


    }
    interface RecyclerViewClickListener{


        fun  recyclerViewClicked(item:Article)
    }
}
