import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.news.MediaDAO

class MediaRepository(private val mediaDAO: MediaDAO) {
    fun allMedias(): LiveData<List<Media>> = mediaDAO.getAllMedias()

    fun insertMedia(media: Media){
        mediaDAO.insertMedia(media)
    }
}