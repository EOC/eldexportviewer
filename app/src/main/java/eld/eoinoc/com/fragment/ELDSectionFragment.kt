package eld.eoinoc.com.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.model.ListLine

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class ELDSectionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_eldsectionitem_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = ItemRecyclerViewAdapter(this.arguments.getSerializable(LIST) as List<ListLine>)
        }
        return view
    }

    companion object {

        val LIST = "LIST"

        fun newInstance(userList: ArrayList<ListLine>): ELDSectionFragment {
            val fragment = ELDSectionFragment()
            val args = Bundle()
            args.putSerializable(LIST, userList)
            fragment.arguments = args
            return fragment
        }
    }
}
