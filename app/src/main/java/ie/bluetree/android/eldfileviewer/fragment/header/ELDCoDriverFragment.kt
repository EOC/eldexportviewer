package ie.bluetree.android.eldfileviewer.fragment.header


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import ie.bluetree.android.R


/**
 * A simple [Fragment] subclass.
 */
class ELDCoDriverFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_eldco_driver, container, false)
        val coDriverName = rootView.findViewById<TextView>(R.id.coDriverFullName)
        val coDriverUserName = rootView.findViewById<TextView>(R.id.coDriverUserName)
        val noDriverInfo = rootView.findViewById<TextView>(R.id.noDriverInfo)

        if (this.arguments.getString(CODRIVER_NAME).isNullOrEmpty()) {
            coDriverName.visibility = View.INVISIBLE
            coDriverUserName.visibility = View.INVISIBLE
            noDriverInfo.visibility = View.VISIBLE

        } else {
            coDriverName.text = this.arguments.getString(CODRIVER_NAME)
            coDriverUserName.text = this.arguments.getString(CODRIVER_USERNAME)
            noDriverInfo.visibility = View.INVISIBLE
        }
        return rootView
    }

    companion object {
        val CODRIVER_NAME = "CODRIVER_NAME"
        val CODRIVER_USERNAME = "CODRIVER_USERNAME"

        fun newInstance(coDriverFullName: String?, userName: String?): ELDCoDriverFragment {
            val fragment = ELDCoDriverFragment()
            val args = Bundle()
            args.putSerializable(CODRIVER_NAME, coDriverFullName)
            args.putSerializable(CODRIVER_USERNAME, userName)
            fragment.arguments = args
            return fragment
        }
    }

}
