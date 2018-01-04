package ie.bluetree.android.eldfileviewer.data

/**
 * Created by eoinoc on 31/12/2017.
 */
enum class ELDExportHeaders(val header: String) {
    HEADER_SEGMENT("ELD File Header Segment:"),
    USER_LIST("User List:"),
    CMV_LIST("CMV List:"),
    EVENT_LIST("ELD Event List:"),
    EVENT_ANNOTATIONS("ELD Event Annotations or Comments:"),
    DRIVER_CERTIFICATION("Driver's Certification/Recertification Actions:"),
    MALFUNCTIONS("Malfunctions and Data Diagnostic Events:"),
    LOGINS("ELD Login/Logout Report:"),
    POWER_UPS("CMV Engine Power-Up and Shut Down Activity:"),
    UNIDENTIFIED("Unidentified Driver Profile Records:")
}