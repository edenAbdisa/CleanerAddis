package com.iyoa.cleanaddis.adapters.news

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.iyoa.cleanaddis.R


import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.entity.posting.Post

import kotlinx.android.synthetic.main.fragment_news.view.*
import java.util.*


class MyNewsRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ArticleViewHolder>() {

    private var articles: List<Article> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
         val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = inflater
            .inflate(R.layout.fragment_news, parent, false)


        return ArticleViewHolder(recyclerViewItem)
    }

    internal fun getArticles():List<Article>{
        return articles
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val course: Article = articles.get(position)
        Log.wtf("ArticleLine35",course.text)

        holder.mIdView.text = course.title
        holder.mContentView.text = course.published_date.toString()


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

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }


    }
}
