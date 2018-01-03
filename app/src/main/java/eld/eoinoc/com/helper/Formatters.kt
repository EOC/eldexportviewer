package eld.eoinoc.com.helper

import java.text.SimpleDateFormat

/**
 * Created by eoinoc on 02/01/2018.
 */

fun formatEventDateTime(eventDate: String, eventTime: String) : String {
    val formatter = SimpleDateFormat("MMddyyHHmmss")
    val eventListFormat = SimpleDateFormat("MMM dd HH:mm")
    val eventDateTime = formatter.parse(eventDate + eventTime)
    return eventListFormat.format(eventDateTime)
}

fun formatVehicleMiles(vehicleMiles: String) : String {
    return vehicleMiles + "mi."
}

fun formatEngineHours(engineHours: String) : String {
    return engineHours + "hrs"
}

fun getEventType(eventType: String, eventCode: String) : String {
    val eventPair = Pair(eventType, eventCode)
    ELDEventCodes.values().filter { it.eventTypeEventCodePair == eventPair }
            .forEach { return it.eventText }

    return "Unknown Event"
}