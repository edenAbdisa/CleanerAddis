package com.iyoa.cleanaddis.controller.news

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.databinding.FragmentNewsBinding
import com.iyoa.cleanaddis.databinding.NewsDetailFragmentBinding
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel

class ArticleDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleDetailFragment()
    }

    private val articleDetailViewModel by lazy{ViewModelProviders.of(this).get(ArticleViewModel::class.java)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      //val view = inflater.inflate(R.layout.news_detail_fragment,container,false)

        val binding:NewsDetailFragmentBinding= DataBindingUtil.setContentView(this.requireActivity(), R.layout.news_detail_fragment)
            //DataBindingUtil.inflate(inflater ,R.layout.news_detail_fragment,container , false)
        val article = arguments?.getSerializable("article") as Article
        var myView : View  = binding.root
        binding.text = article.text
        binding.title = article.title




        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        //viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context != null) {
            // Get dog names and descriptions.

        }
    }
}
