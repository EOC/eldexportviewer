package eld.eoinoc.com.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class UserListLine(val accountType: String, val lastName: String, val firstName: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        if (accountType == "S") {
            sb.append("Support")
        } else {
            sb.append("Driver")
        }
        sb.append("  |  ")

        if (firstName == UNIDENTIFIED) {
            sb.append("Unidentified Driver")
        } else {
            sb.append(lastName).append(", ").append(firstName)
        }
        return sb.toString()
    }

    companion object {
        val UNIDENTIFIED = "unidentified"
    }
}