package ie.bluetree.android.eldfileviewer.helper

import ie.bluetree.android.eldfileviewer.model.Category
import ie.bluetree.android.eldfileviewer.model.Theme
import java.util.ArrayList

/**
 * Created by eoinoc on 31/12/2017.
 */
class CategoryHelper {

    private var categories: MutableList<Category> = loadCategories()

    fun getCategories(): List<Category> {
        return categories
    }

    fun getCategoryWith(categoryId: String): Category {
        categories
                .filter { it.id == categoryId }
                .forEach { return it }

        return categories.first()
    }

    fun getIndexOfCategoryForPager(categoryId: String): Int {
        categories
                .filter { it.id == categoryId }
                .forEach { return categories.indexOf(it) - 1 }

        return 0
    }

    private fun loadCategories(): MutableList<Category> {
        val sections = ArrayList<Category>()
        sections.add(Category("Header Segment", "header", Theme.blue))
        sections.add(Category("User List", "users", Theme.blue))
        sections.add(Category("CMV List", "cmvs", Theme.lightblue))
        sections.add(Category("Event List", "events", Theme.lightblue))
        sections.add(Category("Comments", "comments", Theme.blue))
        sections.add(Category("Certification", "certification", Theme.blue))
        sections.add(Category("Malfunctions", "malfunctions", Theme.lightblue))
        sections.add(Category("Login/Logout", "logins", Theme.lightblue))
        sections.add(Category("Power Up/Down", "engine", Theme.blue))
        sections.add(Category("Unidentified Driver", "unidentified", Theme.blue))
        return sections
    }
}