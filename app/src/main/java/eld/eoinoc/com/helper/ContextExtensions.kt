package eld.eoinoc.com.helper

import android.content.Context
import eld.eoinoc.com.data.ELDExportFileData

/**
 * Created by eoinoc on 01/01/2018.
 */


fun Context.driverData() = ELDExportFileData.getInstance(this)