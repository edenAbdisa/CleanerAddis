package com.iyoa.cleanaddis.controller.posting

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.iyoa.cleanaddis.R
import kotlinx.android.synthetic.main.fragment_after_media_choosen.view.*
import android.graphics.BitmapFactory
import android.view.View.GONE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.data.posting.LabelUUID
import com.iyoa.cleanaddis.entity.common.Media
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.utility.DateUtility
import com.iyoa.cleanaddis.viewModels.common.LabelViewModel
import com.iyoa.cleanaddis.viewModels.news.CategoryViewModel
import com.iyoa.cleanaddis.viewModels.common.MediaViewModel
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import kotlinx.android.synthetic.main.fragment_after_media_choosen.*
import java.io.*


class AfterMediaChoosenFragment : DialogFragment() {
    lateinit var bitmapImage: Bitmap
    lateinit var videoUri:String
    lateinit var imgUri:String
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val inflater = requireActivity().layoutInflater;
        val view=inflater.inflate(R.layout.fragment_after_media_choosen, null)

        val _imv = view.imageView_choosen_Media_display
        val _vid = view.videoView_choosen_Media_display
        val bun=arguments
        if(bun?.getString("type").equals("Image")) {
            Toast.makeText(context,"image",Toast.LENGTH_SHORT).show()
            imgUri= bun?.getString("pathUri").toString()
            bitmapImage = BitmapFactory.decodeByteArray(bun?.getByteArray("image"), 0,bun?.getByteArray("image")!!.size)
            _vid.visibility= GONE
            _imv.setImageBitmap(bitmapImage)
        }else{
            Toast.makeText(context,"video",Toast.LENGTH_SHORT).show()
            videoUri= bun?.getString("path").toString()
            _imv.visibility= GONE
            _vid.setVideoPath(videoUri)
            _vid.requestFocus()
            _vid.start()

            _vid.setOnClickListener{
                _vid.requestFocus()
                _vid.start()
            }
        }
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(view)
                .setPositiveButton("PostUUID",
                    DialogInterface.OnClickListener { dialog, id ->
                        var postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
                        var labelViewModel = ViewModelProviders.of(this).get(LabelViewModel::class.java)
                        var media: MediaUUID?=null
                        if( _imv.visibility!= GONE){
                            //media= addMedia("PHOTO",imgUri)
                        }else{
                            // media = addMedia("VIDEO",videoUri)
                        }
                        var label: LabelUUID?=null

                        // use categoryViewModel to get the label or category u need to write a repository and dao code
                        labelViewModel.getLabelByName("POST")
                        labelViewModel.getResponse.observe(this, Observer {
                                response -> response.body()?.run{
                            label=this

                        }
                        })
                        Toast.makeText(context,"Sucessfully posted category"+label!!.uuid,Toast.LENGTH_LONG).show()
                        Toast.makeText(context,"Sucessfully posted media"+media!!.uuid,Toast.LENGTH_LONG).show()
                        val post = insertPost(media!!.uuid,label!!.uuid)
                        postViewModel.insertPost(post)
                        postViewModel.insertResponse.observe(this, Observer { response ->
                            response.body()?.run{
                                Toast.makeText(context,"Sucessfully posted",Toast.LENGTH_LONG).show()
                            }
                        })

                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog().cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
    fun addMedia(mediatype:String,mediaData:String): MediaUUID? {

        var mediaViewModel = ViewModelProviders.of(this).get(MediaViewModel::class.java)
        val file= File(mediaData)

        val out=FileOutputStream(file)


        var newMedia= Media(mediaData,mediatype,"POST","editText_post_description.text.toString()")
        //  mediaViewModel.insertMedia(file,newMedia)
        mediaViewModel.insertMediaResponse.observe(this, Observer { response ->
            response.body()?.run{
                mediaViewModel.media.set(this)
            }
        })
        return mediaViewModel.media.get()
    }

    fun insertPost(mediaUuid:String,categoryUuid:String):Post {
        val sharedPreference =
            activity?.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        var username: String = sharedPreference!!.getString("username", "null")
        var noLike: Int = 0
        var noView: Int = 0
        var downloadable: Int = 1
        var allowToBeUsedForArticle: Int = 1
        var mediaUuid: String=mediaUuid
        var categoryUuid: String=categoryUuid
        var canBeViewedBy: String = "ALL"
        var status: String = "POSTED"

        var canBeUsedArticleSelectedButton = radioGroup_can_be_used_for_article.checkedRadioButtonId
        if (canBeUsedArticleSelectedButton == radioButton_dont_use_for_article.id) {
            allowToBeUsedForArticle = 0
        }

        var downloadableSelectedButton = radioGroup_downloadable.checkedRadioButtonId
        if (downloadableSelectedButton == radioButton_disable_download.id) {
            downloadable = 0
        }

        var selectedViewersButton = radioGroup_post_viewer.checkedRadioButtonId
        if (selectedViewersButton == radioButton_friends_of_friends.id) {
            canBeViewedBy = "FRIENDSOFFRIENDS"
        } else if (selectedViewersButton == radioButton_friends.id) {
            canBeViewedBy = "FRIENDS"
        } else if (selectedViewersButton == radioButton_me_only.id) {
            canBeViewedBy = "MEONLY"
        }
        var post = Post( username, noLike, noView, downloadable, allowToBeUsedForArticle, mediaUuid,
            categoryUuid, canBeViewedBy, status, DateUtility.getCurrentDate()
        )
        return post
    }
}
