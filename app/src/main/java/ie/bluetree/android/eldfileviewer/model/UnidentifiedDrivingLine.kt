package ie.bluetree.android.eldfileviewer.model

import ie.bluetree.android.eldfileviewer.helper.*

/**
 * Created by eoinoc on 02/01/2018.
 */
class UnidentifiedDrivingLine(val recordStatus: String, val recordOrigin: String, val eventType: String, val eventCode: String, val eventDate: String,
                              val eventTime: String, val accumulatedMiles: String, val accumulatedEngineHours: String, val latitude: String, val longitude: String, val distanceSinceLastValidCoords: String,
                              val cmvOrderNum: String, malfunctionIndicatorStatus: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(getEventType(eventType, eventCode)).append(", ")
        sb.append(formatEventDateTime(eventDate, eventTime)).append(", ")
        sb.append(formatVehicleMiles(accumulatedMiles)).append(", ")
        sb.append(formatEngineHours(accumulatedEngineHours)).append(", ")
        sb.append(latitude).append(", ").append(longitude).append(", ")
        return sb.toString()
    }
}