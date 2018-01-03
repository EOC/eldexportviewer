package eld.eoinoc.com.activity

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import eld.eoinoc.com.fragment.ELDCategorySelectionFragment
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.helper.replaceFragment
import android.content.Intent
import eld.eoinoc.com.fragment.SelectFileFragment
import eld.eoinoc.com.helper.driverData
import eld.eoinoc.com.helper.findFragmentById


class ELDCategorySelectionActivity : AppCompatActivity() {

    var driverDataLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eldcategory_selection)
        setUpToolbar()
        if (savedInstanceState == null || !driverDataLoaded) {
            replaceFragment(R.id.category_container, SelectFileFragment())
        } else {
            replaceFragment(R.id.category_container, ELDCategorySelectionFragment())
        }
        setProgressBarVisibility(View.GONE)
    }

    override fun onResume() {
        super.onResume()
        if (driverDataLoaded && findFragmentById(R.id.category_container) is SelectFileFragment) {
            replaceFragment(R.id.category_container, ELDCategorySelectionFragment())
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar_viewer))
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setProgressBarVisibility(visibility: Int) {
        findViewById<View>(R.id.progress).visibility = visibility
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_openfile) {
            performFileSearch()
            true
        } else super.onOptionsItemSelected(item)
    }

    fun performFileSearch() {
        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE)

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.type = "*/*"

        startActivityForResult(intent, READ_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                driverData().readExportFile(contentResolver.openInputStream(data.data))
                driverDataLoaded = true
            }
        }
    }

    companion object {
        val READ_REQUEST_CODE:Int = 42
    }
}
