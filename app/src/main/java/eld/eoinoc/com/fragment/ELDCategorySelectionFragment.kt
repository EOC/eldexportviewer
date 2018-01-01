package eld.eoinoc.com.fragment

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import eld.eoinoc.com.adapter.CategoryAdapter
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.activity.ELDSectionActivity
import eld.eoinoc.com.helper.TransitionHelper
import eld.eoinoc.com.model.Category
import eld.eoinoc.com.widget.OffsetDecoration

/**
 * Created by eoinoc on 30/12/2017.
 */
class ELDCategorySelectionFragment : Fragment() {

    private val adapter: CategoryAdapter? by lazy(LazyThreadSafetyMode.NONE) {
        CategoryAdapter(activity,
                AdapterView.OnItemClickListener { _, v, position, _ ->
                    adapter?.getItem(position)?.let {
                        startCategoryActivityWithTransition(activity,
                                v.findViewById(R.id.category_title), it)
                    }
                })
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_categories, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpCategoryGrid(view.findViewById<RecyclerView>(R.id.categories))
        super.onViewCreated(view, savedInstanceState)
    }

    @SuppressLint("NewApi")
    private fun setUpCategoryGrid(categoriesView: RecyclerView) {
        with(categoriesView) {
            addItemDecoration(OffsetDecoration(context.resources
                    .getDimensionPixelSize(R.dimen.spacing_nano)))
            adapter = this@ELDCategorySelectionFragment.adapter
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun startCategoryActivityWithTransition(activity: Activity, toolbar: View,
                                                category: Category) {

        val animationBundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                *TransitionHelper.createSafeTransitionParticipants(activity,
                        false,
                        Pair(toolbar, activity.getString(R.string.transition_toolbar))))
                .toBundle()

        // Start the activity with the participants, animating from one to the other.
        val startIntent = ELDSectionActivity.getStartIntent(activity, category)
        startActivityForResult(startIntent, REQUEST_CATEGORY, animationBundle)
    }

    companion object {

        private const val REQUEST_CATEGORY = 0x2300
    }
}