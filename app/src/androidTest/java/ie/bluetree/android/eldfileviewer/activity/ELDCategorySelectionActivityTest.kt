package ie.bluetree.android.eldfileviewer.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import ie.bluetree.android.R
import ie.bluetree.android.eldfileviewer.helper.CategoryHelper
import ie.bluetree.android.eldfileviewer.model.Category
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by eoinoc on 03/01/2018.
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class ELDCategorySelectionActivityTest {

    private lateinit var categories: List<Category>

    @Before
    fun loadCategories() {
        categories = CategoryHelper().getCategories()
    }

    @Test
    fun allCategoriesAreDisplayed() {
        var categoryName: String
        categories.indices.forEach {
            categoryName = categories[it].name
            onView(withId(R.id.categories))
                    .perform(RecyclerViewActions
                            .actionOnItemAtPosition<RecyclerView.ViewHolder>(it, scrollTo()))
            onView(withText(categoryName)).check(matches(isDisplayed()))
        }
    }
}