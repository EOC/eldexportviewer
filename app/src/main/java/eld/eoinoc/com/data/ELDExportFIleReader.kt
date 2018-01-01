package eld.eoinoc.com.data

import eld.eoinoc.com.eld_export_fileviewer.R
import android.content.Context
import android.content.res.Resources
import eld.eoinoc.com.model.HeaderSegment
import java.io.InputStream

/**
 * Created by eoinoc on 31/12/2017.
 */
class ELDExportFIleReader private constructor(
        context: Context
) {

    private val resources: Resources = context.resources
    var headerSegment: HeaderSegment? = null

    init {
        readExportFile()
    }

    private fun readExportFile() {
        val inputStream: InputStream = resources.openRawResource(R.raw.demo_export)
        val lineList = mutableListOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

        //Lines 1-8 are is header segment data
        headerSegment = populateHeaderSegmentData(lineList.subList(1, 8))
    }

    fun readLine(dataType: Int, line: String) {
        when (dataType) {
            2 -> readerUserListLine(line)
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
    }

    fun readerUserListLine(userListLine: String) {

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
                "Unidentified Driver Profile Records:")

        private var _instance: ELDExportFIleReader? = null

        fun getInstance(context: Context): ELDExportFIleReader {
            return _instance ?: synchronized(ELDExportFIleReader::class) {
                ELDExportFIleReader(context).also { _instance = it }
            }
        }
    }
}