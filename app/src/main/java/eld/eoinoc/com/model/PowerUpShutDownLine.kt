package eld.eoinoc.com.model

import eld.eoinoc.com.helper.*

/**
 * Created by eoinoc on 02/01/2018.
 */
class PowerUpShutDownLine (val eventCode: String, val eventDate: String, val eventTime: String, val vehicleMiles: String, val engineHours: String,
                           val latitude: String, val longitude: String, val cmvPowerUnitNumber: String, val cmvVIN: String, val trailers: String,
                           val shippingDoc: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(getEventType(ELDEventCodes.POWER_EVENT_TYPE, eventCode)).append(", ")
        sb.append(formatEventDateTime(eventDate, eventTime)).append(", ")
        sb.append(formatVehicleMiles(vehicleMiles)).append(", ")
        sb.append(formatEngineHours(engineHours)).append(", ")
        sb.append(latitude).append(", ").append(longitude)
        sb.append(cmvPowerUnitNumber).append(", ").append(cmvVIN)
        sb.append(trailers).append(", ").append(shippingDoc)
        return sb.toString()
    }
}