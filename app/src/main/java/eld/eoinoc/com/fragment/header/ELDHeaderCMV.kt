package eld.eoinoc.com.fragment.header

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.fragment.OnFragmentInteractionListener

class ELDHeaderCMV : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null

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

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
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
