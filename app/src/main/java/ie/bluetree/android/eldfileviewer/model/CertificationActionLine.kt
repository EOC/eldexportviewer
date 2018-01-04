package ie.bluetree.android.eldfileviewer.model

import ie.bluetree.android.eldfileviewer.helper.ELDEventCodes
import ie.bluetree.android.eldfileviewer.helper.formatEventDateTime
import ie.bluetree.android.eldfileviewer.helper.getEventType

/**
 * Created by eoinoc on 02/01/2018.
 */
class CertificationActionLine(val eventCode: String, val eventDate: String, val eventTime: String, val dateOfCertifiedRecord: String, val cmvOrder: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(getEventType(ELDEventCodes.CERTIFICATION_EVENT_TYPE, "").format(eventCode)).append(", ")
        sb.append(formatEventDateTime(eventDate, eventTime)).append(", ")
        sb.append(dateOfCertifiedRecord).append(", ")
        sb.append(cmvOrder)
        return sb.toString()
    }
}