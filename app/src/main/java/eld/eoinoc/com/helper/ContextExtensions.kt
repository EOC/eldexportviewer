package eld.eoinoc.com.helper

import android.content.Context
import eld.eoinoc.com.data.ELDExportFIleReader

/**
 * Created by eoinoc on 01/01/2018.
 */


fun Context.driverData() = ELDExportFIleReader.getInstance(this)