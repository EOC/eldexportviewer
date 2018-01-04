package ie.bluetree.android.eldfileviewer.widget

import android.annotation.TargetApi
import android.os.Build
import android.support.v4.app.SharedElementCallback
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import ie.bluetree.android.eldfileviewer.helper.ViewUtils

/**
 * Created by eoinoc on 31/12/2017.
 */
/**
 * This callback allows a shared TextView to resize text and start padding during transition.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
open class TextSharedElementCallback(
        private val initialTextSize: Float,
        private val initialPaddingStart: Int
) : SharedElementCallback() {

    private var targetViewTextSize = 0f
    private var targetViewPaddingStart = 0

    override fun onSharedElementStart(sharedElementNames: List<String>?,
                                      sharedElements: List<View>,
                                      sharedElementSnapshots: List<View>?) {
        val targetView = getTextView(sharedElements)
        if (targetView == null) {
            Log.w(TAG, "onSharedElementStart: No shared TextView, skipping.")
            return
        }
        targetViewTextSize = targetView.textSize
        targetViewPaddingStart = targetView.paddingStart
        // Setup the TextView's start values.
        targetView.setTextSize(TypedValue.COMPLEX_UNIT_PX, initialTextSize)
        ViewUtils.setPaddingStart(targetView, initialPaddingStart)
    }

    override fun onSharedElementEnd(sharedElementNames: List<String>?,
                                    sharedElements: List<View>,
                                    sharedElementSnapshots: List<View>?) {
        val initialView = getTextView(sharedElements)

        if (initialView == null) {
            Log.w(TAG, "onSharedElementEnd: No shared TextView, skipping")
            return
        }

        // Setup the TextView's end values.
        initialView.setTextSize(TypedValue.COMPLEX_UNIT_PX, targetViewTextSize)
        ViewUtils.setPaddingStart(initialView, targetViewPaddingStart)

        // Re-measure the TextView (since the text size has changed).
        val widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        with(initialView) {
            measure(widthSpec, heightSpec)
            requestLayout()
        }
    }

    private fun getTextView(sharedElements: List<View>) =
            sharedElements.filter { it is TextView }.first() as TextView?

    companion object {
        private const val TAG = "TextResize"
    }

}
