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
class ELDCarrierFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_eldcarrier, container, false)
        val usDotNumber = rootView.findViewById<TextView>(R.id.usDotNumber)
        val carrierName = rootView.findViewById<TextView>(R.id.carrierName)
        val multiDayBasis = rootView.findViewById<TextView>(R.id.multiDayBasis)
        val period = rootView.findViewById<TextView>(R.id.period)
        val timeZoneOffset = rootView.findViewById<TextView>(R.id.timezoneOffset)

        usDotNumber.text = this.arguments.getString(USDOT_NUMBER)
        carrierName.text = this.arguments.getString(CARRIER_NAME)
        multiDayBasis.text = this.arguments.getString(MULTIDAY_BASIS)
        period.text = this.arguments.getString(H_PERIOD)
        timeZoneOffset.text = this.arguments.getString(TIMEZONE_OFFSET)
        return rootView
    }

    companion object {
        val USDOT_NUMBER = "USDOT_NUMBER"
        val CARRIER_NAME = "CARRIER_NAME"
        val MULTIDAY_BASIS = "MULTIDAY_BASIS"
        val H_PERIOD = "H_PERIOD"
        val TIMEZONE_OFFSET = "TIMEZONE_OFFSET"

        fun newInstance(usDOTNumber: String?, carrierName: String?, multidayBasis: String?, period: String?, timezoneOffset: String?): ELDCarrierFragment {
            val fragment = ELDCarrierFragment()
            val args = Bundle()
            args.putSerializable(USDOT_NUMBER, usDOTNumber)
            args.putSerializable(CARRIER_NAME, carrierName)
            args.putSerializable(MULTIDAY_BASIS, multidayBasis)
            args.putSerializable(H_PERIOD, period)
            args.putSerializable(TIMEZONE_OFFSET, timezoneOffset)
            fragment.arguments = args
            return fragment
        }
    }
}
