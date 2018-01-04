package ie.bluetree.android.eldfileviewer.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ie.bluetree.android.eldfileviewer.fragment.header.*
import ie.bluetree.android.eldfileviewer.model.HeaderSegment

/**
 * Created by eoinoc on 01/01/2018.
 */
class HeaderPagerAdapter(fragmentManager: FragmentManager, private val data: HeaderSegment?) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return ELDCoDriverFragment.newInstance(data!!.getCoDriverFullName(), data!!.coDriverELDUserName)
            1 -> return ELDHeaderCMV.newInstance(data!!.powerUnitNumber, data!!.vin, data!!.trailerNumbers)
            2 -> return ELDCarrierFragment.newInstance(data!!.usDOTNumber, data!!.carrierNumber, data!!.multiDayBasis, data!!.startingTime, data!!.timeZoneOffset)
            3 -> return ELDShippingFragment.newInstance(data!!.shippingDocNumber, data!!.exemptDriverConfig)
            4 -> return ELDHeaderVehicle.newInstance(data!!.date, data!!.time, data!!.lat, data!!.long, data!!.vehicleMiles, data!!.engineHours)
            5 -> return ELDInfoFragment.newInstance(data!!.eldRegID, data!!.eldIdentifier, data!!.eldAuthValue)

        }
        return ELDHeaderCMV.newInstance(data!!.powerUnitNumber, data!!.vin, data!!.trailerNumbers)
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence {
        return arrayOf(
                "Co-Driver",
                "CMV",
                "Carrier",
                "Shipping",
                "Vehicle",
                "ELD")[position]
    }
}