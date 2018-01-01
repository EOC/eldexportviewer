package eld.eoinoc.com.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Interpolator
import android.widget.ImageView
import android.widget.TextView
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.helper.ApiLevelHelper
import eld.eoinoc.com.helper.CategoryHelper
import eld.eoinoc.com.helper.driverData
import eld.eoinoc.com.model.Category
import eld.eoinoc.com.widget.TextSharedElementCallback
import android.support.v4.view.ViewPager
import eld.eoinoc.com.adapter.HeaderPagerAdapter
import eld.eoinoc.com.fragment.OnFragmentInteractionListener


/**
 * Created by eoinoc on 31/12/2017.
 */
class ELDSectionActivity : OnFragmentInteractionListener, AppCompatActivity() {

    private val interpolator: Interpolator = FastOutSlowInInterpolator()
    private lateinit var category: Category

    private var headerPagerAdapter: HeaderPagerAdapter? = null
    private var viewPager: ViewPager? = null

    private var icon: ImageView? = null
    private var toolbarBack: View? = null

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.back -> onBackPressed()
            else -> throw UnsupportedOperationException(
                    "OnClick has not been implemented for " + resources.getResourceName(it.id))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        populate(intent.getStringExtra(Category.TAG))
        val categoryNameTextSize = resources
                .getDimensionPixelSize(R.dimen.category_item_text_size)
        val paddingStart = resources.getDimensionPixelSize(R.dimen.spacing_double)
        val startDelay = resources.getInteger(R.integer.toolbar_transition_duration).toLong()
        ActivityCompat.setEnterSharedElementCallback(this,
                object : TextSharedElementCallback(categoryNameTextSize.toFloat(), paddingStart) {
                    override fun onSharedElementStart(sharedElementNames: List<String>?,
                                                      sharedElements: List<View>,
                                                      sharedElementSnapshots: List<View>?) {
                        super.onSharedElementStart(sharedElementNames,
                                sharedElements,
                                sharedElementSnapshots)
                        toolbarBack?.let {
                            it.scaleX = 0f
                            it.scaleY = 0f
                        }
                    }

                    override fun onSharedElementEnd(sharedElementNames: List<String>?,
                                                    sharedElements: List<View>,
                                                    sharedElementSnapshots: List<View>?) {
                        super.onSharedElementEnd(sharedElementNames,
                                sharedElements,
                                sharedElementSnapshots)
                        // Make sure to perform this animation after the transition has ended.
                        ViewCompat.animate(toolbarBack)
                                .setStartDelay(startDelay)
                                .scaleX(1f)
                                .scaleY(1f)
                                .alpha(1f)
                    }
                })
    }

    @SuppressLint("NewApi")
    private fun populate(categoryId: String) {
        category = CategoryHelper().getCategoryWith(categoryId).also {
            setTheme(it.theme.styleId)
            if (ApiLevelHelper.isAtLeast(Build.VERSION_CODES.LOLLIPOP)) {
                window.statusBarColor = ContextCompat.getColor(this, it.theme.primaryDarkColor)
            }
            initLayout(it.id)
            initToolbar(it)
        }
    }

    private fun initLayout(categoryId: String) {
        setContentView(R.layout.activity_eldsection)
        val header  = driverData().headerSegment
        headerPagerAdapter = HeaderPagerAdapter(getSupportFragmentManager(), header)
        viewPager = findViewById(R.id.headerPager)
        viewPager!!.adapter  = headerPagerAdapter


        toolbarBack = findViewById<View>(R.id.back).apply { setOnClickListener(onClickListener) }

        if (categoryId == "header") {
            findViewById<View>(R.id.header_fragment_container).visibility = View.VISIBLE

            val driverName : TextView = findViewById<TextView>(R.id.driverName)
            driverName.text = header?.getDriverFullname()

            val licenceData : TextView = findViewById<TextView>(R.id.licenseInfo)
            licenceData.text = header?.getLicenseInfo()

            val eldUserName : TextView = findViewById<TextView>(R.id.eldUserName)
            eldUserName.text = header?.eldUserName

        }
    }

    private fun initToolbar(category: Category) {
        with(findViewById<TextView>(R.id.category_title)) {
            text = category.name
            setTextColor(ContextCompat.getColor(this@ELDSectionActivity, category.theme.textPrimaryColor))
        }
    }

    override fun onBackPressed() {

        ViewCompat.animate(toolbarBack)
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(100L)
                .start()

        // Scale the icon and fab to 0 size before calling onBackPressed if it exists.
        ViewCompat.animate(icon)
                .scaleX(.7f)
                .scaleY(.7f)
                .alpha(0f)
                .setInterpolator(interpolator)
                .start()

    }

    override fun onFragmentInteraction(uri: Uri) {
        //Don't do anything yet
    }

    companion object {

        private val IMAGE_CATEGORY = "image_category_"
        private val FRAGMENT_TAG = "ELDSection"

        fun getStartIntent(context: Context, category: Category): Intent {
            return Intent(context, ELDSectionActivity::class.java)
                    .apply { putExtra(Category.TAG, category.id) }
        }
    }
}