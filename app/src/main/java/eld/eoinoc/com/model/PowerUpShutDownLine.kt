package eld.eoinoc.com.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class PowerUpShutDownLine (val eventCode: String, val eventDate: String, val eventTime: String, val vehicleMiles: String, val engineHours: String,
                           val latitude: String, val longitude: String, val cmvPowerUnitNumber: String, val cmvVIN: String, val trailers: String,
                           val shippingDoc: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(eventCode).append(", ")
        sb.append(eventDate).append(", ").append(eventTime).append(", ").append(vehicleMiles).append(", ").append(engineHours)
        return sb.toString()
    }
}