package com.iyoa.cleanaddis.controller.news

import android.app.Application
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
import com.iyoa.cleanaddis.entity.resources.Media

import kotlinx.android.synthetic.main.fragment_news.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyNewsRecyclerViewAdapter(
    private val mValues: List<DummyItem>,
    private val mListener: OnListFragmentInteractionListener?

) : RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.



            // Add media for trial on the cloud firestore





            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_news, parent, false)

        //getting reference for the add news button in news fragment(fragment_news)
        val store = ViewHolder(view).mStoreButton

        //Connecting to the firestore database
         var db: FirebaseFirestore = InitFirestore().initFirestore()


        //OnclickListener for the add news button
        store.setOnClickListener {


            //getting reference to the trash collection I'm going to create
            var mTrashCollection: CollectionReference = db.collection("trash")


            //getting reference to the media document I'm going to create inside the trash collection
            var media: Media = Media("images/delilah.png","IMAGE","article"
                ,"this is my second first article")


            //adding media to the trash collection
            mTrashCollection.document("media").set(media).addOnSuccessListener {
                    void: Void? -> Toast.makeText(parent.context,"sucess!", Toast.LENGTH_LONG)
            }.addOnFailureListener{
                    exception: java.lang.Exception ->  Toast.makeText(parent.context,"not sucess!", Toast.LENGTH_LONG)

            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.title_news_card
        val mContentView: TextView = mView.subtitle_news_card
         val mStoreButton:Button = mView.add_news
        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }


    }
}
