package eld.eoinoc.com.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import eld.eoinoc.com.fragment.ELDCategorySelectionFragment
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.helper.replaceFragment

class ELDCategorySelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eldcategory_selection)
        if (savedInstanceState == null) {
            replaceFragment(R.id.category_container, ELDCategorySelectionFragment())
        }
        setProgressBarVisibility(View.GONE)
    }

    private fun setProgressBarVisibility(visibility: Int) {
        findViewById<View>(R.id.progress).visibility = visibility
    }
}
