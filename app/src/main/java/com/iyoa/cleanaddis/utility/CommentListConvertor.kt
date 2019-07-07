package com.iyoa.cleanaddis.utility

import android.util.JsonReader
import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.iyoa.cleanaddis.data.posting.CommentUUID
import java.util.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.converter.moshi.MoshiConverterFactory


class CommentListConvertor {



    @TypeConverter
    fun toCommentUUIDList(commentString: String): List<CommentUUID>? {
       val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, CommentUUID::class.java)
        val adapter:JsonAdapter<List<CommentUUID>?> = moshi.adapter<List<CommentUUID>>(type)
        val commentUUIDList:List<CommentUUID>? = adapter.fromJson(commentString)
        return commentUUIDList
    }

}