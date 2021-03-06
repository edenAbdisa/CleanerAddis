package com.iyoa.cleanaddis.controller.news

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.news.MyNewsRecyclerViewAdapter

import com.iyoa.cleanaddis.controller.news.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.retrofit.ArticleService
import com.iyoa.cleanaddis.retrofit.ArticleServiceImpl
import com.iyoa.cleanaddis.utility.Connection.Companion.checkConnection
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ArticleFragment.OnListFragmentInteractionListener] interface.
 */
class ArticleFragment : Fragment(),MyNewsRecyclerViewAdapter.RecyclerViewClickListener {
    lateinit var articleViewModel: ArticleViewModel
    val context = MainActivity()
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var  articleService: ArticleService
    lateinit var recyclerView: RecyclerView

    override fun recyclerViewClicked(item:Article) {
        //val articleFragment = ArticleDetailFragment()
        val args = Bundle()
        args.putSerializable("article",item)

        NavHostFragment.findNavController(this).navigate(R.id.action_article_list_to_article_detail, args)

}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val articleListAdapter = MyNewsRecyclerViewAdapter(context,this)
        var articleList = articleListAdapter.getArticles()

        val view = inflater.inflate(R.layout.fragment_news_list, container, false)


        recyclerView = view.findViewById(R.id.fragment_news_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        articleListAdapter.notifyDataSetChanged()

        recyclerView.adapter = articleListAdapter
        recyclerView.setHasFixedSize(true)



        if(checkConnection(view?.context)) {
            loadArticles(articleListAdapter, articleList)
        }
        else{
            getArticles(articleListAdapter)
        }



        return view
    }

    private fun getArticles(articleListAdapter: MyNewsRecyclerViewAdapter) {
        articleViewModel = ViewModelProviders.of(this).get(
            ArticleViewModel::class.java
        )

        articleViewModel.allArticles.observe(this,androidx.lifecycle.Observer {
                articles->articles?.let{articleListAdapter.setArticlesForApi(it)}
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
        */
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

    fun loadArticles(articleListAdapter:MyNewsRecyclerViewAdapter,  articleList:List<Article>){
        var articleList = articleList
        articleService = ArticleServiceImpl().getArticleServiceImpl()
        val call: Call<List<Article>> = articleService.findArticles()
        call.enqueue(object:Callback<List<Article>>{
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {

                articleList = response.body() as List<Article>
                articleListAdapter.setArticlesForApi(articleList)
                addArticles(articleList)
                Log.println(Log.INFO, "ArticleLine81", articleList?.get(0).toString())
            }

            override fun onFailure(call:Call<List<Article>>,t:Throwable){
                Log.wtf("ArticleLine85",t.message)
            }

        })
    }

    fun addArticles(article:List<Article>){
        //check connection,if the device is online or not
        //if device is online, add latest articles to room..if not load the ones already in room
        articleViewModel = ViewModelProviders.of(this).get(
            ArticleViewModel::class.java
        )

        articleViewModel.allArticles.observe(this,androidx.lifecycle.Observer {
                articles->articles?.let{MyNewsRecyclerViewAdapter(context,this).setArticlesForApi(articles)}
        })
        run{articleViewModel.addArticles(article)}






    }


    fun addNews(){
        /*
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
                  */





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
