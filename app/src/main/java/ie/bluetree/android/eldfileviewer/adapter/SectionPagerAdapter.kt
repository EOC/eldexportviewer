package ie.bluetree.android.eldfileviewer.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ie.bluetree.android.eldfileviewer.data.ELDExportFileData
import ie.bluetree.android.eldfileviewer.fragment.ELDSectionFragment

/**
 * Created by eoinoc on 02/01/2018.
 */
class SectionPagerAdapter (fragmentManager: FragmentManager,  private val data: ELDExportFileData) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return ELDSectionFragment.newInstance(data.userList)
            1 -> return ELDSectionFragment.newInstance(data.cmvList)
            2 -> return ELDSectionFragment.newInstance(data.eventList)
            3 -> return ELDSectionFragment.newInstance(data.commentList)
            4 -> return ELDSectionFragment.newInstance(data.certifiedActionList)
            5 -> return ELDSectionFragment.newInstance(data.diagnosticEventsList)
            6 -> return ELDSectionFragment.newInstance(data.loginLogoutEventsList)
            7 -> return ELDSectionFragment.newInstance(data.powerUpEvents)
            8 -> return ELDSectionFragment.newInstance(data.unidentifiedDrivingEvents)
        }
        return ELDSectionFragment.newInstance(data.userList)
    }

    override fun getCount(): Int {
        return 9
    }

    override fun getPageTitle(position: Int): CharSequence {
        return arrayOf(
                "User List",
                "CMV List",
                "Event List",
                "Comments",
                "Certification/Recertification",
                "Malfunctions/Data Diagnostic",
                "Login/Logout",
                "Engine Power Up/Shut Down",
                "Unidentified Driver"
                )[position]
    }
}