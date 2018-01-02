package eld.eoinoc.com.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class CertificationActionLine(val eventCode: String, val eventDate: String, val eventTime: String, val dateOfCertifiedRecord: String, val cmvOrder: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(eventCode).append(", ")
        .append(eventDate).append(", ")
        .append(eventTime).append(", ")
        .append(dateOfCertifiedRecord).append(", ")
                .append(cmvOrder)
        return sb.toString()
    }
}