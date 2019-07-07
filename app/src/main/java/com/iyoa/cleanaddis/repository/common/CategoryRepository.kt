import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.CategoryDAO

class CategoryRepository(private val categoryDAO: CategoryDAO) {
    fun allCategories(): LiveData<List<Category>> = categoryDAO.getAllCategory()

    fun insertMedia(category: Category){
        categoryDAO.insertCategory(category)
    }
    fun getCategoryByName(name: String): Category{
        return categoryDAO.getCategoryByName(name)
    }
}