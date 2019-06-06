package com.iyoa.cleanaddis.controller.posting

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.iyoa.cleanaddis.R
import kotlinx.android.synthetic.main.fragment_after_media_choosen.*
import kotlinx.android.synthetic.main.fragment_after_media_choosen.view.*
import android.content.Intent.getIntent
import android.graphics.BitmapFactory
import android.content.Intent
import android.content.Intent.getIntentOld
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.widget.ImageView
import android.widget.Toast


class AfterMediaChoosenFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       // if (getIntentOld().hasExtra("byteArray")) {

     val inflater = requireActivity().layoutInflater;
        val view=inflater.inflate(R.layout.fragment_after_media_choosen, null)

        val _imv = view.imageView_choosen_Media_display
        val _vid = view.videoView_choosen_Media_display
        val bun=arguments
        if(bun?.getString("type").equals("Image")) {
            Toast.makeText(context,"image",Toast.LENGTH_SHORT).show()
            val _bitmap = BitmapFactory.decodeByteArray(
                bun?.getByteArray("image")
                , 0,
                bun?.getByteArray("image")!!.size
            )
            _vid.visibility= GONE
            _imv.setImageBitmap(_bitmap)
        }else{
            Toast.makeText(context,"video",Toast.LENGTH_SHORT).show()
           val videoUri= bun?.getString("path")
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
                .setPositiveButton("Post",
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog().cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


}
