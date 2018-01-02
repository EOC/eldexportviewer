package eld.eoinoc.com.helper

import eld.eoinoc.com.model.Category
import eld.eoinoc.com.model.Theme
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

    private fun loadCategories(): MutableList<Category> {
        val sections = ArrayList<Category>(5)
        sections.add(Category("Header Segment", "header", Theme.green))
        sections.add(Category("User List", "users", Theme.blue))
        sections.add(Category("CMV List", "cmvs", Theme.red))
        sections.add(Category("Event List", "events", Theme.yellow))
        sections.add(Category("Comments", "comments", Theme.purple))
        sections.add(Category("Certification/Recertification", "certification", Theme.topeka))
        sections.add(Category("Malfunctions/Data Diagnostic", "malfunctions", Theme.green))
        sections.add(Category("Login/Logout", "logins", Theme.blue))
        sections.add(Category("Engine Power Up/Shut Down", "engine", Theme.red))
        sections.add(Category("Unidentified Driver", "unidentified", Theme.yellow))
        return sections
    }
}