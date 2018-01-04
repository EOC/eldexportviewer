package ie.bluetree.android.eldfileviewer.model

import ie.bluetree.android.eldfileviewer.helper.formatEventDateTime
import ie.bluetree.android.eldfileviewer.helper.getEventType

/**
 * Created by eoinoc on 02/01/2018.
 */
class EventLine (val recordStatus: String, val recordOrigin: String, val eventType: String, val eventCode: String, val eventDate: String,
                 val eventTime: String, val accumulatedMiles: String, val accumulatedEngineHours: String, val latitude: String, val longitude: String, val distanceSinceLastValidCoords: String,
                 val cmvOrderNum: String, malfunctionIndicatorStatus: String, dataDiagnosticEventIndicatorStatus: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(getEventType(eventType, eventCode)).append(", ")
        sb.append(formatEventDateTime(eventDate, eventTime))
        return sb.toString()
    }
}