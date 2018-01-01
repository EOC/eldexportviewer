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

class ELDHeaderVehicle : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_eldheader_vehicle, container, false)
        val date = rootView.findViewById<TextView>(R.id.date)
        val time = rootView.findViewById<TextView>(R.id.time)
        val latitude = rootView.findViewById<TextView>(R.id.latitude)
        val longitude = rootView.findViewById<TextView>(R.id.longitude)
        val vehicleMiles = rootView.findViewById<TextView>(R.id.vehicleMiles)
        val engineHours = rootView.findViewById<TextView>(R.id.engineHours)

        date.text = this.arguments.getString(DATE)
        time.text = this.arguments.getString(TIME)
        latitude.text = this.arguments.getString(LATITIUDE)
        longitude.text = this.arguments.getString(LONGITUDE)
        vehicleMiles.text = this.arguments.getString(VEHICLE_MILES)
        engineHours.text = this.arguments.getString(ENGINE_HOURS)


        return rootView
    }

    companion object {
        val DATE = "DATE"
        val TIME = "TIME"
        val LATITIUDE ="LATITUDE"
        val LONGITUDE = "LONGITUDE"
        val VEHICLE_MILES = "VEHICLE_MILES"
        val ENGINE_HOURS = "ENGINE_HOURS"

        fun newInstance(date: String?, time: String?, latitude: String?, longitude: String?, vehicleMiles: String?, engineHours: String?): ELDHeaderVehicle {
            val fragment = ELDHeaderVehicle()
            val args = Bundle()
            args.putSerializable(DATE, date)
            args.putSerializable(TIME, time)
            args.putSerializable(LATITIUDE, latitude)
            args.putSerializable(LONGITUDE, longitude)
            args.putSerializable(VEHICLE_MILES, vehicleMiles)
            args.putSerializable(ENGINE_HOURS, engineHours)
            fragment.arguments = args
            return fragment
        }
    }
}
