package ie.bluetree.android.eldfileviewer.helper

/**
 * Created by eoinoc on 02/01/2018.
 */
enum class ELDEventCodes(val eventTypeEventCodePair:Pair<String, String>, val eventText: String) {
    OFF_DUTY(Pair("1","1"), "OFF"),
    SLEEPER(Pair("1","2"), "SB"),
    DRIVING(Pair("1","3"), "DRIVE"),
    ON_DUTY(Pair("1","4"), "ON"),
    CONVENTIONAL(Pair("2","1"), "Convential Precision"),
    REDUCED(Pair("2","2"), "Reduced Precision"),
    PERSONAL(Pair("3","1"), "PERSONAL"),
    YARD(Pair("3","2"), "YARD"),
    CLEARED(Pair("3","0"), "PC/YD Cleared"),
    CERTIFICATION(Pair("4",""), "Certification %s"),
    LOGIN(Pair("5","1"), "Login"),
    LOGOUT(Pair("5","2"), "Logout"),
    POWER_UP_REDUCED(Pair("6","1"), "Power Up"),
    POWER_UP_CONVENTIONAL(Pair("6","2"), "Power Up"),
    POWER_DOWN_REDUCED(Pair("6","3"), "Power Down"),
    POWER_DOWN_CONVENTIONAL(Pair("6","4"), "Power Down");

    companion object {
        val DUTY_CHANGE_EVENT_TYPE = "1"
        val CERTIFICATION_EVENT_TYPE = "4"
        val LOGIN_EVENT_TYPE = "5"
        val POWER_EVENT_TYPE = "6"
    }
}