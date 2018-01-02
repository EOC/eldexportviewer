package eld.eoinoc.com.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class LoginLogoutLine (val eventCode: String, val eldUserName: String, val eventDate: String, val eventTime: String, val vehicleMiles: String, val engineHours: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(eventCode).append(", ").append(eldUserName).append(", ")
        sb.append(eventDate).append(", ").append(eventTime).append(", ").append(vehicleMiles).append(", ").append(engineHours)
        return sb.toString()
    }
}