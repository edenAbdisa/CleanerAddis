package com.iyoa.cleanaddis.utility

import android.util.JsonReader
import androidx.annotation.Nullable
import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.squareup.moshi.*
import java.util.*
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.lang.reflect.Type

class CommentListConvertor(){}