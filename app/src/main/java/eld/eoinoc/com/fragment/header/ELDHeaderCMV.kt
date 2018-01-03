package eld.eoinoc.com.fragment.header

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import eld.eoinoc.com.eld_export_fileviewer.R

class ELDHeaderCMV : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_eldheader_cmv, container, false)
        val powerUnitNumber = rootView.findViewById<TextView>(R.id.powerUnitNumber)
        val vin = rootView.findViewById<TextView>(R.id.vin)
        val trailers = rootView.findViewById<TextView>(R.id.trailers)

        powerUnitNumber.text = this.arguments.getString(CMV_NUM)
        vin.text = this.arguments.getString(VIN)
        trailers.text = this.arguments.getString(TRAILERS)

        return rootView
    }

    companion object {
        val CMV_NUM = "CMV_NUM"
        val VIN = "VIN"
        val TRAILERS ="TRAILERS"

        fun newInstance(cmvNum: String?, vin: String?, trailers: String?): ELDHeaderCMV {
            val fragment = ELDHeaderCMV()
            val args = Bundle()
            args.putSerializable(CMV_NUM, cmvNum)
            args.putSerializable(VIN, vin)
            args.putSerializable(TRAILERS, trailers)
            fragment.arguments = args
            return fragment
        }
    }
}
