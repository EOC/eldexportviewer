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
class ELDShippingFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView = inflater!!.inflate(R.layout.fragment_eldshipping, container, false)
        val shippingDoc = rootView.findViewById<TextView>(R.id.shippingDoc)
        val driverExempt = rootView.findViewById<TextView>(R.id.driverExempt)

        shippingDoc.text = this.arguments.getString(SHIPPING_DOC)
        driverExempt.text = this.arguments.getString(EXEMPT_DRIVER)

        return rootView
    }

    companion object {
        val SHIPPING_DOC = "SHIPPING_DOC"
        val EXEMPT_DRIVER = "EXEMPT_DRIVER"

        fun newInstance(shippingDoc: String?, exemptDriver: String?): ELDShippingFragment {
            val fragment = ELDShippingFragment()
            val args = Bundle()
            args.putSerializable(SHIPPING_DOC, shippingDoc)
            args.putSerializable(EXEMPT_DRIVER, exemptDriver)
            fragment.arguments = args
            return fragment
        }
    }
}
