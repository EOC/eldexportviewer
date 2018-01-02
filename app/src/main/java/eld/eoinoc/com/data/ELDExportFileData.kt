package eld.eoinoc.com.data

import android.content.Context
import android.content.res.Resources
import eld.eoinoc.com.eld_export_fileviewer.R
import eld.eoinoc.com.model.*
import java.io.InputStream

/**
 * Created by eoinoc on 31/12/2017.
 */
class ELDExportFileData private constructor(
        context: Context
) {

    private val resources: Resources = context.resources
    var headerSegment: HeaderSegment? = null
    var userList: ArrayList<ListLine> = ArrayList()
    var cmvList: ArrayList<ListLine> = ArrayList()
    var eventList: ArrayList<ListLine> = ArrayList()
    var commentList: ArrayList<ListLine> = ArrayList()
    var certifiedActionList: ArrayList<ListLine> = ArrayList()
    var diagnosticEventsList: ArrayList<ListLine> = ArrayList()
    var loginLogoutEventsList: ArrayList<ListLine> = ArrayList()
    var powerUpEvents: ArrayList<ListLine> = ArrayList()
    var unidentifiedDrivingEvents: ArrayList<ListLine> = ArrayList()

    init {
        readExportFile()
    }

    private fun readExportFile() {
        val inputStream: InputStream = resources.openRawResource(R.raw.demo_export)
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

        //Lines 1-8 are is header segment data
        headerSegment = populateHeaderSegmentData(lineList.subList(1, 8))

        //Lines 9 - index of CMV List make up the user list
        userList = populateUserListSegmentData(lineList.subList(9, lineList.indexOf(HEADERS[2])))

        cmvList = populateCMVListSegmentData(lineList.subList(lineList.indexOf(HEADERS[2]) + 1, lineList.indexOf(HEADERS[3])))

        eventList = populateEventListSegmentData(lineList.subList(lineList.indexOf(HEADERS[3]) + 1, lineList.indexOf(HEADERS[4])))

        commentList = populateCommentListSegmentData(lineList.subList(lineList.indexOf(HEADERS[4]) + 1, lineList.indexOf(HEADERS[5])))

        certifiedActionList = populateCertifiedActionListSegmentData(lineList.subList(lineList.indexOf(HEADERS[5]) + 1, lineList.indexOf(HEADERS[6])))

        diagnosticEventsList = populateDiagnosticEventsData(lineList.subList(lineList.indexOf(HEADERS[6]) + 1, lineList.indexOf(HEADERS[7])))

        loginLogoutEventsList = populateLoginLogoutEventsData(lineList.subList(lineList.indexOf(HEADERS[7]) + 1, lineList.indexOf(HEADERS[8])))

        powerUpEvents = populatePowerUpEvents(lineList.subList(lineList.indexOf(HEADERS[8]) + 1, lineList.indexOf(HEADERS[9])))

        unidentifiedDrivingEvents = populateUnidentifiedDrivingEventsData(lineList.subList(lineList.indexOf(HEADERS[9]) + 1, lineList.indexOf(HEADERS[10])))

    }

    private fun populateUserListSegmentData(userListSegmentLines: MutableList<String>): ArrayList<ListLine> {
        var userLines: ArrayList<ListLine> = ArrayList()
        for (l in userListSegmentLines) {
            var lineData = l.split(",")
            userLines.add(UserListLine(lineData[1], lineData[2], lineData[3]))
        }
        return userLines
    }


    private fun populateCMVListSegmentData(cmvListSegmentLines: MutableList<String>): ArrayList<ListLine> {
        var cmvLines: ArrayList<ListLine> = ArrayList()
        for (l in cmvListSegmentLines) {
            var lineData = l.split(",")
            cmvLines.add(CMVListLine(lineData[1], lineData[2]))
        }
        return cmvLines
    }

    private fun populateCommentListSegmentData(commentListSegmentLines: MutableList<String>): ArrayList<ListLine> {
        var commentLines: ArrayList<ListLine> = ArrayList()
        for (l in commentListSegmentLines) {
            var lineData = l.split(",")
            commentLines.add(CommentListLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5]))
        }
        return commentLines
    }

    private fun populateCertifiedActionListSegmentData(certfiedActionSegmentLines: MutableList<String>): ArrayList<ListLine> {
        var commentLines: ArrayList<ListLine> = ArrayList()
        for (l in certfiedActionSegmentLines) {
            var lineData = l.split(",")
            commentLines.add(CertificationActionLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5]))
        }
        return commentLines
    }

    private fun populateLoginLogoutEventsData(loginEvents: MutableList<String>): ArrayList<ListLine> {
        var loginLogoutLines: ArrayList<ListLine> = ArrayList()
        for (l in loginEvents) {
            var lineData = l.split(",")
            loginLogoutLines.add(LoginLogoutLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5], lineData[6]))
        }
        return loginLogoutLines
    }

    private fun populateDiagnosticEventsData(diagnosticEvents: MutableList<String>): ArrayList<ListLine> {
        var diagnosticLines: ArrayList<ListLine> = ArrayList()
        for (l in diagnosticEvents) {
            var lineData = l.split(",")
            diagnosticLines.add(DiagnosticEventLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5], lineData[6]))
        }
        return diagnosticLines
    }

    private fun populatePowerUpEvents(powerUpEvents: MutableList<String>): ArrayList<ListLine> {
        var powerUpLines: ArrayList<ListLine> = ArrayList()
        for (l in powerUpEvents) {
            var lineData = l.split(",")
            powerUpLines.add(PowerUpShutDownLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5],
                    lineData[6], lineData[7], lineData[8], lineData[9], lineData[10], lineData[11]))
        }
        return powerUpLines
    }

    private fun populateEventListSegmentData(events: MutableList<String>): ArrayList<ListLine> {
        var eventLines: ArrayList<ListLine> = ArrayList()
        for (l in events) {
            var lineData = l.split(",")
            eventLines.add(EventLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5],
                    lineData[6], lineData[7], lineData[8], lineData[9], lineData[10], lineData[11], lineData[12], lineData[13], lineData[13]))
        }
        return eventLines
    }

    private fun populateUnidentifiedDrivingEventsData(unidentifiedDrivingEvents: MutableList<String>): ArrayList<ListLine> {
        var unidentifiedDrivingLines: ArrayList<ListLine> = ArrayList()
        for (l in unidentifiedDrivingEvents) {
            var lineData = l.split(",")
            unidentifiedDrivingLines.add(UnidentifiedDrivingLine(lineData[1], lineData[2], lineData[3], lineData[4], lineData[5],
                    lineData[6], lineData[7], lineData[8], lineData[9], lineData[10], lineData[11], lineData[12], lineData[13]))
        }
        return unidentifiedDrivingLines
    }

    private fun populateHeaderSegmentData(headerSegmentLines: MutableList<String>): HeaderSegment {

        //Driver Info - Line 0
        var lineData = headerSegmentLines[0].split(",")
        val headerSegment = HeaderSegment(lineData.get(0),
                lineData.get(1),
                lineData.get(2),
                lineData.get(3),
                lineData.get(4))


        //CoDriverInfo - Line 2
        lineData = headerSegmentLines[1].split(",")
        headerSegment.addCoDriverDetails(lineData.get(0), lineData.get(1), lineData.get(2))

        //CMVDetails - Line 3
        lineData = headerSegmentLines[2].split(",")
        headerSegment.addCMVDetails(lineData.get(0), lineData.get(1), lineData.get(2))

        //Carrier Info - Line 4
        lineData = headerSegmentLines[3].split(",")
        headerSegment.addCarrierInfo(lineData.get(0), lineData.get(1), lineData.get(2), lineData.get(3), lineData.get(4))

        //Shipping Doc - Line 5
        lineData = headerSegmentLines[4].split(",")
        headerSegment.addShippingInfo(lineData.get(0), lineData.get(1))

        //Shipping Doc - Line 6
        lineData = headerSegmentLines[5].split(",")
        headerSegment.addVehicleInfo(lineData.get(0), lineData.get(1), lineData.get(2), lineData.get(3), lineData.get(4), lineData.get(5))

        //ELD Info - Line 7
        lineData = headerSegmentLines[6].split(",")
        headerSegment.addELDInfo(lineData.get(0), lineData.get(1), lineData.get(2))

        return headerSegment
    }

    companion object {
        val HEADERS = arrayOf("ELD File Header Segment:",
                "User List:",
                "CMV List:",
                "ELD Event List:",
                "ELD Event Annotations or Comments:",
                "Driver's Certification/Recertification Actions:",
                "Malfunctions and Data Diagnostic Events:",
                "ELD Login/Logout Report:",
                "CMV Engine Power-Up and Shut Down Activity:",
                "Unidentified Driver Profile Records:",
                "End of File:")

        private var _instance: ELDExportFileData? = null

        fun getInstance(context: Context): ELDExportFileData {
            return _instance ?: synchronized(ELDExportFileData::class) {
                ELDExportFileData(context).also { _instance = it }
            }
        }
    }
}