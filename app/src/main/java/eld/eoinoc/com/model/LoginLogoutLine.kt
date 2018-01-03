package eld.eoinoc.com.model

import eld.eoinoc.com.helper.*

/**
 * Created by eoinoc on 02/01/2018.
 */
class LoginLogoutLine (val eventCode: String, val eldUserName: String, val eventDate: String, val eventTime: String, val vehicleMiles: String, val engineHours: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(getEventType(ELDEventCodes.LOGIN_EVENT_TYPE, eventCode)).append(", ").append(eldUserName).append(", ")
        sb.append(formatEventDateTime(eventDate, eventTime)).append(", ")
        sb.append(formatVehicleMiles(vehicleMiles)).append(", ").append(formatEngineHours(engineHours))
        return sb.toString()
    }
}