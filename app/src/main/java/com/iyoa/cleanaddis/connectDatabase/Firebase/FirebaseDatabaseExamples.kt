package com.iyoa.cleanaddis.connectDatabase.Firebase

import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.iyoa.cleanaddis.entity.resources.Media

class FirebaseDatabaseExamples {
    /*
    fun example(){
        //getting reference for the add news button in news fragment(fragment_news)
        //val store = ViewHolder(view).mStoreButton

        //Connecting to the firestore database
        var db: FirebaseFirestore = InitFirestore().initFirestore()


        //OnclickListener for the add news button
        //store.setOnClickListener {


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
    }*/
}