import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.news.CategoryDAO
import com.iyoa.cleanaddis.data.news.MediaDAO

class CategoryRepository(private val categoryDAO: CategoryDAO) {
    fun allCategories(): LiveData<List<Category>> = categoryDAO.getAllCategory()

    fun insertMedia(category: Category){
        categoryDAO.insertCategory(category)
    }
}