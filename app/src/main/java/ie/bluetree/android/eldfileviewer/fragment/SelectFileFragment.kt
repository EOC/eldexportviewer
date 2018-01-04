package ie.bluetree.android.eldfileviewer.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import ie.bluetree.android.eldfileviewer.activity.ELDCategorySelectionActivity
import ie.bluetree.android.R

/**
 * Created by eoinoc on 03/01/2018.
 */
class SelectFileFragment : Fragment()  {

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.openFileButton -> launchFileSearch()
            else -> throw UnsupportedOperationException(
                    "OnClick has not been implemented for " + resources.getResourceName(it.id))
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_selectfile, container, false)
        rootView.findViewById<ImageButton>(R.id.openFileButton).setOnClickListener(onClickListener)
        return rootView
    }


    private fun launchFileSearch() {
        (activity as ELDCategorySelectionActivity).performFileSearch()
    }
}