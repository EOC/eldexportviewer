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
class ELDInfoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_eldinfo, container, false)
        val eldRegId = rootView.findViewById<TextView>(R.id.eldRegId)
        val eldIdentifier = rootView.findViewById<TextView>(R.id.eldIdentifier)
        val eldAuth = rootView.findViewById<TextView>(R.id.eldAuth)

        eldRegId.text = this.arguments.getString(ELD_REG_ID)
        eldIdentifier.text = this.arguments.getString(ELD_IDENTIFIER)
        eldAuth.text = this.arguments.getString(ELD_AUTH_VALUE)

        return rootView
    }

    companion object {
        val ELD_REG_ID = "ELD_REG_ID"
        val ELD_IDENTIFIER = "ELD_IDENTIFIER"
        val ELD_AUTH_VALUE = "ELD_AUTH"

        fun newInstance(eldRegID: String?, eldIdentifier: String?, eldAuthValue: String?): ELDInfoFragment {
            val fragment = ELDInfoFragment()
            val args = Bundle()
            args.putSerializable(ELD_REG_ID, eldRegID)
            args.putSerializable(ELD_IDENTIFIER, eldIdentifier)
            args.putSerializable(ELD_AUTH_VALUE, eldAuthValue)
            fragment.arguments = args
            return fragment
        }
    }

}
