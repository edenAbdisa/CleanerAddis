package com.iyoa.cleanaddis.adapters.news

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.connectDatabase.Firebase.InitFirestore


import com.iyoa.cleanaddis.controller.news.NewsFragment.OnListFragmentInteractionListener
import com.iyoa.cleanaddis.controller.news.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.entity.resources.Media

import kotlinx.android.synthetic.main.fragment_news.view.*


class MyNewsRecyclerViewAdapter(context: Context) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ArticleViewHolder>() {



    private val inflater = LayoutInflater.from(context)
    private var articles: List<Article> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val recyclerViewItem = inflater
            .inflate(R.layout.fragment_news, parent, false)


        return ArticleViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val course = articles[position]
        holder.mIdView.text = course.title
        holder.mContentView.text = course.text


    }

    override fun getItemCount(): Int = articles.size

    inner class ArticleViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.title_news_card
        val mContentView: TextView = mView.subtitle_news_card
         val mStoreButton:Button = mView.add_news
        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }


    }
}
