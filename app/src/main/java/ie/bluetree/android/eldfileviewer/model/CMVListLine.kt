package ie.bluetree.android.eldfileviewer.model

/**
 * Created by eoinoc on 02/01/2018.
 */
class CMVListLine(val powerUnitNumber: String, val vin: String) : ListLine {
    override fun formatLine(): String {
        val sb = StringBuilder()
        sb.append(powerUnitNumber)
        if(vin.isNotBlank()) {
            sb.append(", ").append(vin)
        }
        return sb.toString()
    }
}