package com.iyoa.cleanaddis.controller.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD:app/src/main/java/com/iyoa/cleanaddis/controller/news/ArticleFragment.kt
import android.widget.Toast
=======
import android.widget.Button
>>>>>>> parent of 77bccfc... Article feature modified:app/src/main/java/com/iyoa/cleanaddis/controller/news/NewsFragment.kt
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.news.MyNewsRecyclerViewAdapter

import com.iyoa.cleanaddis.controller.news.dummy.DummyContent
import com.iyoa.cleanaddis.controller.news.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.news.Article
<<<<<<< HEAD:app/src/main/java/com/iyoa/cleanaddis/controller/news/ArticleFragment.kt
import com.iyoa.cleanaddis.retrofit.ArticleService
import com.iyoa.cleanaddis.retrofit.ArticleServiceImpl
import com.iyoa.cleanaddis.utility.Connection.Companion.checkConnection
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
=======
import com.iyoa.cleanaddis.data.news.ArticleData
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import java.text.SimpleDateFormat
import java.util.*
>>>>>>> parent of 77bccfc... Article feature modified:app/src/main/java/com/iyoa/cleanaddis/controller/news/NewsFragment.kt

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [NewsFragment.OnListFragmentInteractionListener] interface.
 */
class NewsFragment : Fragment() {

    // TODO: Customize parameters
    lateinit var articleViewModel: ArticleViewModel
    val context = MainActivity()
    val articleListAdapter = MyNewsRecyclerViewAdapter(context)

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)
        view.findViewById<View>(R.id.news_card).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_article_list_to_article_detail)

        }

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyNewsRecyclerViewAdapter(context)
            }
        }
        articleViewModel = ViewModelProviders.of(this).get(
            ArticleViewModel::class.java
        )
       articleViewModel.allArticles.observe(this,androidx.lifecycle.Observer {
           articles->articles?.let{MyNewsRecyclerViewAdapter(context).setArticles(articles)}
       })

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }




    fun addNews(){

        val addButton: Button = add_news
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        addButton.setOnClickListener {
            val article =
                Article("1","Plastic","1"
                    ,"Hey there plastic",currentDate,"PUBLISHED",
                    "delilah","delilah",0,"1")

            AsyncTask.execute{
                articleViewModel.insertArticle(article)
            }
              }





    }

    fun viewNews(){


    }
    fun viewAllNews(){
        //get all news
        //use viewmodel to pass data to the UI

    }

    fun editNews(){

    }
    fun deleteNews(){


    }



}
