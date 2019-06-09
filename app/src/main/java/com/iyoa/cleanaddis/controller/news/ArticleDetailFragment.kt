package com.iyoa.cleanaddis.controller.news

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil


import com.iyoa.cleanaddis.R
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

      val view = inflater.inflate(R.layout.news_detail_fragment,container,false)
      /*
        val binding= DataBindingUtil
          .setContentView(this.activity!!.parent,R.layout.news_detail_fragment)
        binding.apply {

        }
        */



        return inflater.inflate(R.layout.news_detail_fragment, container, false)
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
