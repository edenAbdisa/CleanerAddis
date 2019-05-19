package com.iyoa.cleanaddis.connectDatabase.Firebase

import com.google.firebase.firestore.FirebaseFirestore

class InitFirestore {

    private lateinit var mFirestore: FirebaseFirestore;
    fun initFirestore():FirebaseFirestore{

        mFirestore = FirebaseFirestore.getInstance()
        return mFirestore
    }


}