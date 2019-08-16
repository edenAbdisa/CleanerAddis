package com.iyoa.cleanaddis.data.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.android.gms.tasks.Task
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.utility.CommentListConvertor
import java.io.Serializable
import java.util.*

enum class PostStatus {
   POSTED, REMOVEDBYREPORT,DELETED,EDITED
}
enum class CanBeViewedBy {
    FRIENDS,FRIENDSOFFRIENDS,MEONLY,ALL
}

@Entity(tableName = "post")
data class PostUUID (@PrimaryKey val  uuid: String, val username:String,
                     val noLike:Int, val noView: Int, val downloadable: Int,
                     val allowToBeUsedForArticle:Int,
                     var mediaUuid:String, val categoryUuid:String, val canBeViewedBy:String,
                     val status: String,
                     val date:String ){

}

