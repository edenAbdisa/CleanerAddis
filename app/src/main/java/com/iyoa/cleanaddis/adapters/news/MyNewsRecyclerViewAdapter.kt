package com.iyoa.cleanaddis.adapters.news

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
<<<<<<< HEAD
=======
import android.widget.Toast
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.connectDatabase.Firebase.InitFirestore
>>>>>>> parent of 77bccfc... Article feature modified


import com.iyoa.cleanaddis.controller.news.NewsFragment.OnListFragmentInteractionListener
import com.iyoa.cleanaddis.controller.news.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.entity.resources.Media

import kotlinx.android.synthetic.main.fragment_news.view.*
<<<<<<< HEAD
import java.util.*
import android.R
import android.os.Bundle
import com.iyoa.cleanaddis.controller.news.ArticleDetailFragment
import com.iyoa.cleanaddis.controller.news.ArticleFragment
=======
>>>>>>> parent of 77bccfc... Article feature modified


class MyNewsRecyclerViewAdapter(context: Context) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ArticleViewHolder>() {



    private val inflater = LayoutInflater.from(context)
    private var articles: List<Article> = emptyList()
    private var itemListen: RecyclerViewClickListener? = null
    private lateinit var contexts:Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val recyclerViewItem = inflater
            .inflate(com.iyoa.cleanaddis.R.layout.fragment_news, parent, false)


        return ArticleViewHolder(recyclerViewItem)
    }
    fun MyNewsRecyclerViewAdapter(context:Context ,  itemListener:RecyclerViewClickListener) {
        contexts = context
        itemListen = itemListener

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val course = articles[position]
        holder.mIdView.text = course.title
<<<<<<< HEAD
        holder.mContentView.text = course.published_date.toString()
=======
        holder.mContentView.text = course.text
>>>>>>> parent of 77bccfc... Article feature modified


    }
    internal fun setArticles(articles:List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articles.size

    inner class ArticleViewHolder(val mView: View) : RecyclerView.ViewHolder(mView),View.OnClickListener {


        init{
          mView.setOnClickListener(ArticleViewHolder(this.itemView))
        }
        override fun onClick(v: View?) {
            itemListen?.recyclerViewClicked(v,this.layoutPosition)
            var article = v as Article
            val articleFragment = ArticleDetailFragment()
            val args = Bundle()
            args.putSerializable("article",article)
            articleFragment.arguments = args



        }

        val mIdView: TextView = mView.title_news_card
        val mContentView: TextView = mView.subtitle_news_card
         val mStoreButton:Button = mView.add_news
        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }


    }
     interface RecyclerViewClickListener{


         fun  recyclerViewClicked(view:View? ,position:Int)
    }
}
