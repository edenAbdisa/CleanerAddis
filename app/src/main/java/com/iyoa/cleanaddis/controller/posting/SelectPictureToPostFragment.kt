package com.iyoa.cleanaddis.controller.posting

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iyoa.cleanaddis.R
import kotlinx.android.synthetic.main.fragment_select_picture_to_post.view.*
import java.io.ByteArrayOutputStream
import java.net.URI
import android.Manifest
import android.app.Activity
import android.os.Build.*
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import android.R.attr.data
import android.opengl.Visibility
import android.view.View.GONE
import androidx.core.app.NotificationCompat.getExtras
import androidx.room.util.CursorUtil.getColumnIndexOrThrow
import kotlinx.android.synthetic.main.fragment_after_media_choosen.view.*
import android.R.attr.data
import androidx.room.util.CursorUtil.getColumnIndexOrThrow
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*


class SelectPictureToPostFragment : Fragment() {
    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_IMAGE_FROM_GALERY = 2
    private val SELECT_PICTURE = 3
    val REQUEST_VIDEO_CAPTURE = 4
    private val REQUEST_VIDEO_FROM_GALLERY = 5
    private val VIDEO_DIRECTORY = "/cleanerAddis"
    private val TAG = "MainActivity"
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
          val view= inflater.inflate(com.iyoa.cleanaddis.R.layout.fragment_select_picture_to_post, container, false)
        view.button_image_from_camera.setOnClickListener {
            dispatchTakePictureIntent()
        }
        view.button_image_from_gallery.setOnClickListener {
            openImageChooser() 
        }
        view.button_video_from_gallery.setOnClickListener {
            chooseVideoFromGallery()
        }
        view.button_video_from_camera.setOnClickListener {
            dispatchTakeVideoIntent()
        }
        return view
    }
    fun openImageChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE)
    }
    fun chooseVideoFromGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, REQUEST_VIDEO_FROM_GALLERY)
    }
    /* Get the real path from the URI */
    fun getPathFromURI(contentUri: Uri): String? {
        var res: String? = null
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context?.applicationContext?.getContentResolver()?.query(contentUri, proj, null, null, null)
        if (cursor!!.moveToFirst()) {
            val column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            res = cursor.getString(column_index)
        }
        cursor.close()
        return res
    }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(context?.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    private fun dispatchTakeVideoIntent() {
        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
            takeVideoIntent.resolveActivity(context?.packageManager)?.also {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
            }
        }
    }
    fun displayBitMap(bitMap:Bitmap){
        val bundle=Bundle()
        val _bs = ByteArrayOutputStream()
        bitMap.compress(Bitmap.CompressFormat.PNG, 50, _bs)
        bundle.putByteArray("image",_bs.toByteArray())
        bundle.putString("type","Image")
        val newFragment = AfterMediaChoosenFragment()
        newFragment.arguments=bundle
        newFragment.show(childFragmentManager, "Image")
    }
    fun displayVideo(videoUri:Uri){
        val bundle=Bundle()
        bundle.putString("path",videoUri.toString())
        bundle.putString("type","Video")
        val newFragment = AfterMediaChoosenFragment()
        newFragment.arguments=bundle
        newFragment.show(childFragmentManager, "Image")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(data==null){
            return
        }
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data.extras.get("data") as Bitmap
            displayBitMap(imageBitmap)
        }
        if (requestCode == REQUEST_IMAGE_FROM_GALERY && resultCode == RESULT_OK) {

            val thumbnail = data.extras.get("data") as Bitmap
            displayBitMap(thumbnail)
        }
        if(requestCode == SELECT_PICTURE && resultCode == RESULT_OK){
            val selectedImageUri = data!!.data
            var bitmap: Bitmap? = null

            try {
                bitmap = MediaStore.Images.Media.getBitmap(
                    context?.applicationContext?.getContentResolver(), selectedImageUri
                )
            } catch (e: Exception) {
                Toast.makeText(context,"Couldnt select picture",Toast.LENGTH_SHORT).show()
            }
            if (bitmap != null) {
                displayBitMap(bitmap)
            }
        }
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            val videoUri: Uri = data.data
            displayVideo(videoUri)
        }
        if (requestCode === REQUEST_VIDEO_FROM_GALLERY) {
            if (data != null) {
                val contentURI = data.data
                val selectedVideoPath = getPath(contentURI)
               // saveVideoToInternalStorage(selectedVideoPath)
                displayVideo(contentURI)


            }

        }
    }

    fun getPath(uri: Uri): String? {
        val projection = arrayOf(MediaStore.Video.Media.DATA)
        val cursor = context?.applicationContext?.getContentResolver()?.query(uri, projection, null, null, null)
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            val column_index = cursor!!
                .getColumnIndexOrThrow(MediaStore.Video.Media.DATA)
            cursor!!.moveToFirst()
            return cursor!!.getString(column_index)
        } else
            return null
    }

}
