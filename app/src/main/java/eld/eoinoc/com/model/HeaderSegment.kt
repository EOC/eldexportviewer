package eld.eoinoc.com.model

/**
 * Created by eoinoc on 01/01/2018.
 */
class HeaderSegment(
        val lastName: String,
        val firstName: String,
        val eldUserName: String,
        val licenseState: String,
        val licenseNumber: String
) {
    var coDriverLastName: String? = ""
    var coDriverFirstName: String? = ""
    var coDriverELDUserName: String? = ""
    var powerUnitNumber: String? = ""
    var vin: String? = ""
    var trailerNumbers: String? = ""
    var usDOTNumber: String? = ""
    var carrierNumber: String? = ""
    var multiDayBasis: String? = ""
    var startingTime: String? = ""
    var timeZoneOffset: String? = ""
    var shippingDocNumber: String? = ""
    var exemptDriverConfig: String? = ""
    var date: String? = ""
    var time: String? = ""
    var lat: String? = ""
    var long: String? = ""
    var vehicleMiles: String? = ""
    var engineHours: String? = ""
    var eldRegID: String? = ""
    var eldIdentifier: String? = ""
    var eldAuthValue: String? = ""

    fun addCoDriverDetails(lastName: String, firstName: String, eldUserName: String) {
        this.coDriverLastName = lastName
        this.coDriverFirstName = firstName
        this.coDriverELDUserName = eldUserName
    }

    fun addCMVDetails(powerUnitNumber: String, vin: String, trailerNumbers: String){
        this.powerUnitNumber = powerUnitNumber
        this.vin = vin
        this.trailerNumbers = trailerNumbers
    }

    fun addCarrierInfo(usDOTNumber: String, carrierNumber: String, multidayBasis: String, startingTime: String, timezoneOffset: String) {
        this.usDOTNumber = usDOTNumber
        this.carrierNumber = carrierNumber
        this.multiDayBasis = multidayBasis
        this.startingTime = startingTime
        this.timeZoneOffset = timezoneOffset
    }

    fun addShippingInfo(shippingDocNumber: String, exemptDriverConfig: String) {
        this.shippingDocNumber = shippingDocNumber
        this.exemptDriverConfig = exemptDriverConfig
    }

    fun addVehicleInfo(date: String, time: String, lat: String, long: String, vehicleMiles: String, engineHours: String) {
        this.date = date
        this.time = time
        this.lat = lat
        this.long = long
        this.vehicleMiles = vehicleMiles
        this.engineHours = engineHours
    }

    fun addELDInfo(eldRegID: String, eldIdentifier: String, eldAuthValue: String) {
        this.eldRegID = eldRegID
        this.eldIdentifier = eldIdentifier
        this.eldAuthValue = eldAuthValue
    }

    fun getCoDriverFullName(): String {
        return coDriverLastName + ", " + coDriverFirstName
    }

    fun getDriverFullname(): String {
        return lastName + ", " + firstName
    }

    fun getLicenseInfo(): String {
        return licenseNumber + ", " + licenseState
    }
}