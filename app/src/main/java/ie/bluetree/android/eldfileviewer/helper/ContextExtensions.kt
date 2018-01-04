package ie.bluetree.android.eldfileviewer.helper

import android.content.Context
import ie.bluetree.android.eldfileviewer.data.ELDExportFileData

/**
 * Created by eoinoc on 01/01/2018.
 */


fun Context.driverData() = ELDExportFileData.getInstance(this)